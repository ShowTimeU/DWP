package com.dontwaste.exception;

public class InstitutionNotFoundException extends RuntimeException {
    public InstitutionNotFoundException() {
        super();
    }

    public InstitutionNotFoundException(String message) {
        super(message);
    }

    public InstitutionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public InstitutionNotFoundException(Throwable cause) {
        super(cause);
    }
}
