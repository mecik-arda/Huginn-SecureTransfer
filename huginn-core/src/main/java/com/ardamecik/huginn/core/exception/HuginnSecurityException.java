package com.ardamecik.huginn.core.exception;

public class HuginnSecurityException extends RuntimeException {
    public HuginnSecurityException(String message) {
        super("HUGINN_SECURITY_ERROR: " + message);
    }
}
