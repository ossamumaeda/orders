package com.delivery.api.service.dto;

public record ProductCreateRequest(

    String name,

    Long price,

    Integer stockQuantity,

    String code
    
) {

}
