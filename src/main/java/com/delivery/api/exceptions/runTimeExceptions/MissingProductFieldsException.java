package com.delivery.api.exceptions.runTimeExceptions;

public class MissingProductFieldsException extends RuntimeException{
    
    public MissingProductFieldsException(){
        super("There are missing fields in the product information");
    }

    public MissingProductFieldsException(String message){
        super(message);
    }

}