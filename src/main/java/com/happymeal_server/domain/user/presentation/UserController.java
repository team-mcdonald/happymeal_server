package com.happymeal_server.domain.user.presentation;

import com.happymeal_server.domain.user.domain.User;
import com.happymeal_server.domain.user.service.UserService;
import com.happymeal_server.global.annotation.AuthenticationCheck;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @AuthenticationCheck
    @GetMapping("/myinfo")
    @ResponseStatus(HttpStatus.OK)
    public User getMyInfo(@RequestAttribute User user) {
        return user;
    }
}
