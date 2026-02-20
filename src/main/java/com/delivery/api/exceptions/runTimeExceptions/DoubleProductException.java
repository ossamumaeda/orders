package com.delivery.api.exceptions.runTimeExceptions;

public class DoubleProductException extends RuntimeException {

    public DoubleProductException() {
        super("Double products founded!");
    }

    public DoubleProductException(String message) {
        super(message);
    }

}
