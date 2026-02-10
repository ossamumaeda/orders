package com.delivery.api.usecase.dto;

import java.time.Instant;
import java.util.List;

public record OrderCreateResponse(
    String status,
    Instant created_at,
    String customer_name,
    String customer_email,
    List<OrderItemCreateResponse> items
) {
    
}
