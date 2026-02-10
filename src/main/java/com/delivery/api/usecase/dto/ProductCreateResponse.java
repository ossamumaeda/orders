package com.delivery.api.usecase.dto;
public record ProductCreateResponse(
    String name,
    Long price, 
    Integer stockQuantity,
    String code
) {
    
}
