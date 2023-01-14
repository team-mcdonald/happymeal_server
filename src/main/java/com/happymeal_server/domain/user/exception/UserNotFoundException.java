package com.happymeal_server.domain.user.exception;

import com.happymeal_server.global.error.CustomException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends CustomException {

    public static final CustomException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException() {
        super(HttpStatus.NOT_FOUND, "해당 유저를 찾지 못했습니다.");
    }
}
