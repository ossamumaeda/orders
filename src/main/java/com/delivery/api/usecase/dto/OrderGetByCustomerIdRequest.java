package com.delivery.api.usecase.dto;

import java.util.UUID;

public record OrderGetByCustomerIdRequest(
    UUID customer_id
) {
    
}
