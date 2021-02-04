package com.jm.marketplace.exception;

public class UserEmailExistsException extends RuntimeException {

    public UserEmailExistsException() {
        super();
    }

    public UserEmailExistsException(String message) {
        super(message);
    }

    public UserEmailExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
