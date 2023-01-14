package com.happymeal_server.global.lib.encrypt;

import com.happymeal_server.global.error.CustomException;
import org.springframework.http.HttpStatus;

public class EncryptException extends CustomException {

    public static final CustomException EXCEPTION = new EncryptException();

    private EncryptException() {
        super(HttpStatus.INTERNAL_SERVER_ERROR, "암호화 작업 중 서버 오류가 발생했습니다.");
    }
}