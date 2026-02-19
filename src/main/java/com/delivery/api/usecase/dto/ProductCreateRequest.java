package com.delivery.api.usecase.dto;
public record ProductCreateRequest(

    String name,

    Long price,

    Integer stockQuantity,

    String code
    
) {

}
