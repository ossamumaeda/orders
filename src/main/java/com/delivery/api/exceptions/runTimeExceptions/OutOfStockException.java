package com.delivery.api.exceptions.runTimeExceptions;

public class OutOfStockException extends RuntimeException {

    public OutOfStockException() {
        super("Product out of stock!");
    }

    public OutOfStockException(String message) {
        super(message);
    }

}
