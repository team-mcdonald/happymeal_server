package com.happymeal_server.global.error.exception;

import com.happymeal_server.global.error.CustomException;
import org.springframework.http.HttpStatus;

public class ExistLikeException extends CustomException {
    public static final CustomException EXCEPTION = new ExistLikeException();

    private ExistLikeException() {
        super(HttpStatus.FORBIDDEN, "이미 추천하셨습니다");
    }
}
