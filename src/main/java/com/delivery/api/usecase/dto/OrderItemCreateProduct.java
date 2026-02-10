package com.delivery.api.usecase.dto;

import com.delivery.api.domain.product.Product;

public record OrderItemCreateProduct(
    Product product,
    Integer quantity
) {
    
}
