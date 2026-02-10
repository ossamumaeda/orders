package com.delivery.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.api.domain.product.Product;
import com.delivery.api.repositories.ProductRepository;
import com.delivery.api.usecase.dto.ProductCreateRequest;

@Service
public class ProductService {
    
    private final ProductRepository productRepository;

    public ProductService(@Autowired ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product createProduct(ProductCreateRequest productCreateRequest ){

        if(productCreateRequest.name() == null 
            || productCreateRequest.price() == null 
            || productCreateRequest.code() == null
        ){
            return null;
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

        return product;

    }

    public Product getByCode(String code){
        Product product = this.productRepository.findByCode(code).orElseThrow(); // Como tratar isso e nao dar erro na funcao toda
        return product;
    }

}
