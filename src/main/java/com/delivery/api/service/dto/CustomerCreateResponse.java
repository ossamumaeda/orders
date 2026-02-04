package com.delivery.api.service.dto;

import java.util.UUID;

public record CustomerCreateResponse(
    String name,
    String email,
    UUID id
) {
    
}
