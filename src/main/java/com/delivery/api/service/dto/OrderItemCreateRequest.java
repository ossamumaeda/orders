package com.delivery.api.service.dto;

public record OrderItemCreateRequest(
        String code,
        Integer quantity

) {

}
