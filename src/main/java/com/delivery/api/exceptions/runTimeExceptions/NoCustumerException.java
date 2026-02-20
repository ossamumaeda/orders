package com.delivery.api.exceptions.runTimeExceptions;

public class NoCustumerException extends RuntimeException{
    
    public NoCustumerException(){
        super("No customer was found!");
    }

    public NoCustumerException(String message){
        super(message);
    }

}
