package com.delivery.api.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.api.domain.product.Product;
import com.delivery.api.service.ProductService;
import com.delivery.api.usecase.dto.ProductCreateRequest;
import com.delivery.api.usecase.dto.ProductCreateResponse;

@Service
public class ProductCreateUseCase {
    
    private final ProductService productService;
    
    public ProductCreateUseCase(@Autowired ProductService productService){
        this.productService = productService;
    }

    public ProductCreateResponse execute(ProductCreateRequest productCreateRequest){
        
        Product product = this.productService.createProduct(productCreateRequest);
        if(product == null) {
            return null;
        }
        ProductCreateResponse response = new ProductCreateResponse(product.getName(), product.getPrice(), product.getStockQuantity(),product.getCode());

        return response;

    }

}
