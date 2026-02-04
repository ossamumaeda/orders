package com.delivery.api.service.dto;

public record ProductCreateResponse(
    String name,
    Long price, 
    Integer stockQuantity,
    String code
) {
    
}
