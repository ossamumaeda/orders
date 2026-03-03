package com.delivery.api.usecase.dto;
import java.util.List;
import java.util.UUID;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record OrderCreateRequest(
    @NotNull(message = "Customer id can't be null")
    UUID customer_id, // Identificar o usuario
    @NotEmpty(message = "Items can't be empty")
    List<OrderItemCreateRequest> order_items // Lista dos codigos de produtos

) {
    
}
