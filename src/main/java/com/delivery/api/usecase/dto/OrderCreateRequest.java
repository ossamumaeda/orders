package com.delivery.api.usecase.dto;
import java.util.List;
import java.util.UUID;

public record OrderCreateRequest(
    
    UUID customer_id, // Identificar o usuario
    List<OrderItemCreateRequest> order_items // Lista dos codigos de produtos

) {
    
}
