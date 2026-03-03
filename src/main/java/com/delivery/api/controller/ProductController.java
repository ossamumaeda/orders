package com.delivery.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.api.usecase.ProductCreateUseCase;
import com.delivery.api.usecase.dto.ProductCreateRequest;
import com.delivery.api.usecase.dto.ProductCreateResponse;

import jakarta.validation.Valid;


@RestController
@RequestMapping(value = "/product")
public class ProductController {
    
    private final ProductCreateUseCase productCreateUseCase;

    public ProductController(@Autowired ProductCreateUseCase productCreateUseCase){
        this.productCreateUseCase = productCreateUseCase;
    }

    @PostMapping("/create-product")
    public ResponseEntity<ProductCreateResponse> createProduct(@Valid @RequestBody ProductCreateRequest productCreateRequest) {
        
        ProductCreateResponse response = this.productCreateUseCase.execute(productCreateRequest);
        
        return ResponseEntity.ok(response);
        
    }
    

}
