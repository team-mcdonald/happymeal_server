package com.happymeal_server.global.error.exception;

import com.happymeal_server.global.error.CustomException;
import org.springframework.http.HttpStatus;

public class InvalidTokenException extends CustomException {

    public static final CustomException EXCEPTION = new InvalidTokenException();

    private InvalidTokenException() {
        super(HttpStatus.UNAUTHORIZED, "잘못된 토큰입니다.");
    }
}
