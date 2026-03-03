package com.delivery.api.config.dto;

import org.springframework.http.HttpStatus;

public record ExceptionResponse(
    HttpStatus status,
    String message
) {
    
}
