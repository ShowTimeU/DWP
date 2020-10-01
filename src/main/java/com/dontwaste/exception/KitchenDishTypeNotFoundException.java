package com.dontwaste.exception;

public class KitchenDishTypeNotFoundException extends RuntimeException {
    public KitchenDishTypeNotFoundException() {
        super();
    }

    public KitchenDishTypeNotFoundException(String message) {
        super(message);
    }

    public KitchenDishTypeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public KitchenDishTypeNotFoundException(Throwable cause) {
        super(cause);
    }
}
