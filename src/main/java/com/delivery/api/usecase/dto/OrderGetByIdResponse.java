package com.delivery.api.usecase.dto;

import java.time.Instant;
import java.util.List;


public record OrderGetByIdResponse(

    String status_order,
    Instant created_at,
    String customer_name,
    String customer_email,
    List<OrderGetByIdItem> items

) {
    
}
