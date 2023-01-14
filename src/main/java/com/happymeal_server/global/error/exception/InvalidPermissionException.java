package com.happymeal_server.global.error.exception;

import com.happymeal_server.global.error.CustomException;
import org.springframework.http.HttpStatus;

public class InvalidPermissionException extends CustomException {

    public static final CustomException EXCEPTION = new InvalidPermissionException();

    private InvalidPermissionException() {
        super(HttpStatus.FORBIDDEN, "허용되지 않은 권한입니다.");
    }
}
