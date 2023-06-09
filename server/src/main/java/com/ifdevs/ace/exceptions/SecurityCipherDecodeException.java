package com.ifdevs.ace.exceptions;

public class SecurityCipherDecodeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public SecurityCipherDecodeException(String message) {
        super(message);
    }
}
