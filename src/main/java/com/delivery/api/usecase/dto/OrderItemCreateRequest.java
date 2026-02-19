package com.delivery.api.usecase.dto;

public record OrderItemCreateRequest(
        String code,
        Integer quantity
) {

}
