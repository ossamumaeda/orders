package com.delivery.api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delivery.api.domain.product.Product;

public interface ProductRepository extends JpaRepository<Product, UUID>{
    
}
