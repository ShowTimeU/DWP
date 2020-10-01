package com.dontwaste.exception;

public class TemplateNotFoundException extends RuntimeException {
    public TemplateNotFoundException() {
        super();
    }

    public TemplateNotFoundException(String message) {
        super(message);
    }

    public TemplateNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TemplateNotFoundException(Throwable cause) {
        super(cause);
    }
}
