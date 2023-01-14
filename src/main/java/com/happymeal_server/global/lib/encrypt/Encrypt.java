package com.happymeal_server.global.lib.encrypt;

import io.jsonwebtoken.SignatureAlgorithm;

public interface Encrypt {

    SignatureAlgorithm getSignatureAlgorithm();

    String encode(String data);

    boolean match(String originalData, String encryptedData);
}