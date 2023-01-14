package com.happymeal_server.global.error.exception;

import com.happymeal_server.global.error.CustomException;
import org.springframework.http.HttpStatus;

public class QuestionNotFoundException extends CustomException {

    public static final CustomException EXCEPTION = new QuestionNotFoundException();

    private QuestionNotFoundException() {
        super(HttpStatus.NOT_FOUND, "존재하지 않는 질문입니다.");
    }
}
