package com.delivery.api.usecase.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record OrderGetByCustomerIdRequest(
    
    @NotNull(message = "Customer id can't be null")
    UUID customer_id
) {
    
}
