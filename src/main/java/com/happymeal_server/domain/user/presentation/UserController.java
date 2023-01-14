package com.happymeal_server.domain.user.presentation;

import com.happymeal_server.domain.user.domain.User;
import com.happymeal_server.domain.user.presentation.dto.request.UserLoginRequest;
import com.happymeal_server.domain.user.presentation.dto.response.UserLoginResponse;
import com.happymeal_server.domain.user.service.UserService;
import com.happymeal_server.global.annotation.AuthenticationCheck;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @AuthenticationCheck
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public UserLoginResponse login(@RequestBody @Valid UserLoginRequest request) {
        return userService.login(request);
    }

    @AuthenticationCheck
    @GetMapping("/myinfo")
    @ResponseStatus(HttpStatus.OK)
    public User getMyInfo(@RequestAttribute User user) {
        return user;
    }
}
