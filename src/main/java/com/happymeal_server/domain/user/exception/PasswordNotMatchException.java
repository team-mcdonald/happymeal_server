package com.happymeal_server.domain.user.exception;

import com.happymeal_server.global.error.CustomException;
import org.springframework.http.HttpStatus;

public class PasswordNotMatchException extends CustomException {

    public static final CustomException EXCEPTION = new PasswordNotMatchException();

    private PasswordNotMatchException() {
        super(HttpStatus.BAD_REQUEST, "패스워드가 일치하지 않습니다.");
    }
}
