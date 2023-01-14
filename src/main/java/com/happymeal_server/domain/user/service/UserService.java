package com.happymeal_server.domain.user.service;

import com.happymeal_server.domain.user.domain.Consumer;
import com.happymeal_server.domain.user.domain.Provider;
import com.happymeal_server.domain.user.domain.User;
import com.happymeal_server.domain.user.domain.repository.ConsumerRepository;
import com.happymeal_server.domain.user.domain.repository.ProviderRepository;
import com.happymeal_server.domain.user.domain.repository.UserRepository;
import com.happymeal_server.domain.user.domain.types.UserRole;
import com.happymeal_server.domain.user.exception.PasswordNotMatchException;
import com.happymeal_server.domain.user.exception.UserNotFoundException;
import com.happymeal_server.domain.user.presentation.dto.request.UserJoinRequest;
import com.happymeal_server.domain.user.presentation.dto.request.UserLoginRequest;
import com.happymeal_server.domain.user.presentation.dto.response.UserLoginResponse;
import com.happymeal_server.global.lib.encrypt.Encrypt;
import com.happymeal_server.global.lib.jwt.JwtType;
import com.happymeal_server.global.lib.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final ConsumerRepository consumerRepository;
    private final ProviderRepository providerRepository;
    private final Encrypt encrypt;

    public UserLoginResponse login(UserLoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if (!encrypt.match(request.getPassword(), user.getPassword())) {
            throw PasswordNotMatchException.EXCEPTION;
        }

        String accessToken = jwtUtil.createToken(user, JwtType.ACCESS);
        String refreshToken = jwtUtil.createToken(user, JwtType.REFRESH);

        return new UserLoginResponse(accessToken, refreshToken, user);
    }

    public void join(UserJoinRequest request) {

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .password(encrypt.encode(request.getPassword()))
                .role(request.getRole())
                .build();
        userRepository.save(user);

        if (user.getRole().equals(UserRole.CONSUMER)) {
            Consumer consumer = new Consumer(user);
            consumerRepository.save(consumer);
        } else {
            Provider provider = new Provider(user);
            providerRepository.save(provider);
        }
    }
}
