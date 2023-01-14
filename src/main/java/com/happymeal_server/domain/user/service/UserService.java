package com.happymeal_server.domain.user.service;

import com.happymeal_server.domain.user.domain.User;
import com.happymeal_server.domain.user.domain.repository.UserRepository;
import com.happymeal_server.domain.user.exception.UserNotFoundException;
import com.happymeal_server.domain.user.presentation.dto.request.UserLoginRequest;
import com.happymeal_server.domain.user.presentation.dto.response.UserLoginResponse;
import com.happymeal_server.global.lib.JwtType;
import com.happymeal_server.global.lib.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public UserLoginResponse login(UserLoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        String accessToken = jwtUtil.createToken(user, JwtType.ACCESS);
        String refreshToken = jwtUtil.createToken(user, JwtType.REFRESH);

        return new UserLoginResponse(accessToken, refreshToken, user);
    }
}
