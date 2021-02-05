package com.jm.marketplace.exception;

public class UserPhoneExistsException extends RuntimeException {
    public UserPhoneExistsException() {
        super();
    }

    public UserPhoneExistsException(String message) {
        super(message);
    }

    public UserPhoneExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
