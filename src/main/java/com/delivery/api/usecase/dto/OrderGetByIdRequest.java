package com.delivery.api.usecase.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record OrderGetByIdRequest(
    @NotNull(message = "Order id can't be null")
    UUID order_id
) {
    
}
