package com.delivery.api.usecase.dto;
import java.util.UUID;

public record CustomerCreateResponse(
    String name,
    String email,
    UUID id
) {
    
}
