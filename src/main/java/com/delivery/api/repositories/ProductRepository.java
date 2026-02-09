package com.delivery.api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delivery.api.domain.product.Product;
import java.util.Optional;


public interface ProductRepository extends JpaRepository<Product, UUID>{
    
    Optional<Product> findByCode(String code);

}
