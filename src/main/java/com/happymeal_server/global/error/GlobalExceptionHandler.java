package com.happymeal_server.global.error;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ErrorResponse handleCustomException(CustomException e) {
        return new ErrorResponse(
                e.getStatus().value(),
                e.getMessage()
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "인자의 타입이 다릅니다."
        );
    }

    @ExceptionHandler(Exception.class)
    public ErrorResponse handleOtherExceptions(Exception e) {
        e.printStackTrace();
        return new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "서버 에러"
        );
    }
}
