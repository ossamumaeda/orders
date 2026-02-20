package com.delivery.api.usecase.dto;

import java.util.UUID;

public record OrderGetByIdRequest(
    UUID order_id
) {
    
}
