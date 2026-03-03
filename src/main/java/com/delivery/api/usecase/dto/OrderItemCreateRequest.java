package com.delivery.api.usecase.dto;

import jakarta.validation.constraints.NotNull;

public record OrderItemCreateRequest(
        @NotNull(message = "Order code can't be null")
        String code,
        @NotNull(message = "Quantity can't be null")
        Integer quantity
) {

}
