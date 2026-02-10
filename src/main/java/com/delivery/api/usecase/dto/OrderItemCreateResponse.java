package com.delivery.api.usecase.dto;

public record OrderItemCreateResponse(
    Long total_price,
    Integer quantity,
    String product_name,
    String product_code
) {
    
}
