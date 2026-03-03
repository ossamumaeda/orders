package com.delivery.api.config;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.delivery.api.config.dto.ExceptionResponse;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponse> noCustomerException(Exception e) {
        return ResponseEntity.badRequest()
                .body(new ExceptionResponse(HttpStatus.UNPROCESSABLE_CONTENT, e.getMessage()));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionResponse> productAlreadyExists(Exception e) {
        return ResponseEntity.badRequest()
                .body(new ExceptionResponse(HttpStatus.UNPROCESSABLE_CONTENT, e.getMessage()));
    }

}
