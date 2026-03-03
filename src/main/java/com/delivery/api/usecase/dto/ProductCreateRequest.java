package com.delivery.api.usecase.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductCreateRequest(
    
    @NotNull(message = "Name can't be null")
    String name,

    @NotNull(message = "Price can't be null")
    Long price,

    @NotNull(message = "Stocks can't be null")
    @Positive
    Integer stockQuantity,

    @NotNull(message = "Code can't be null")
    String code
    
) {

}
