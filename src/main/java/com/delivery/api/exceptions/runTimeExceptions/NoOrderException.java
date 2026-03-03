package com.delivery.api.exceptions.runTimeExceptions;

public class NoOrderException extends RuntimeException {

    public NoOrderException() {
        super("No order was found!");
    }

    public NoOrderException(String message) {
        super(message);
    }

}
