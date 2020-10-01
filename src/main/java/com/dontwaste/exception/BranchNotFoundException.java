package com.dontwaste.exception;

public class BranchNotFoundException extends RuntimeException {
    public BranchNotFoundException() {
        super();
    }

    public BranchNotFoundException(String message) {
        super(message);
    }

    public BranchNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BranchNotFoundException(Throwable cause) {
        super(cause);
    }
}
