package com.delivery.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.delivery.api.domain.product.Product;
import com.delivery.api.repositories.ProductRepository;
import com.delivery.api.service.dto.ProductCreateRequest;
import com.delivery.api.service.dto.ProductCreateResponse;

@Service
public class ProductService {
    
    private final ProductRepository productRepository;

    public ProductService(@Autowired ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public ResponseEntity<ProductCreateResponse> createProduct(ProductCreateRequest productCreateRequest ){

        if(productCreateRequest.name() == null 
            || productCreateRequest.price() == null 
            || productCreateRequest.code() == null
        ){
            return ResponseEntity.badRequest().body(null);
        }

        Product product = new Product();
        product.setName(productCreateRequest.name());
        product.setPrice(productCreateRequest.price());
        product.setCode(productCreateRequest.code());

        if(productCreateRequest.stockQuantity() == null || productCreateRequest.stockQuantity() < 0){
            product.setStockQuantity(0);
        } else {
            product.setStockQuantity(productCreateRequest.stockQuantity());
        }
        

        product = this.productRepository.save(product);

        ProductCreateResponse productCreateResponse = new ProductCreateResponse(product.getName(), product.getPrice(), product.getStockQuantity(),product.getCode());
        return ResponseEntity.ok(productCreateResponse);

    }

}
