package com.delivery.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.api.service.ProductService;
import com.delivery.api.service.dto.ProductCreateRequest;
import com.delivery.api.service.dto.ProductCreateResponse;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    
    private final ProductService productService;

    public ProductController(@Autowired ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/create-product")
    public ResponseEntity<ProductCreateResponse> postMethodName(@RequestBody ProductCreateRequest productCreateRequest) {
        
        return this.productService.createProduct(productCreateRequest);
        
    }
    

}
