package com.dontwaste.exception;

public class LinkIsNotValidException extends RuntimeException{

    public LinkIsNotValidException() {
        super();
    }

    public LinkIsNotValidException(String message) {
        super(message);
    }

    public LinkIsNotValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public LinkIsNotValidException(Throwable cause) {
        super(cause);
    }
}
