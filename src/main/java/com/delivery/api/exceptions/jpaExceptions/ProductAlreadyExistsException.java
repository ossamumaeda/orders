package com.delivery.api.exceptions.jpaExceptions;

import org.jspecify.annotations.Nullable;
import org.springframework.dao.DataIntegrityViolationException;

public class ProductAlreadyExistsException extends DataIntegrityViolationException{

    public ProductAlreadyExistsException(){
        super("Product already registered");
    }

    public ProductAlreadyExistsException(@Nullable String msg) {
        super(msg);
    }
    
}
