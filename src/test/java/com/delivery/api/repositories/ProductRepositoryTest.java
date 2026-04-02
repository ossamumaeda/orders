/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

package com.delivery.api.repositories;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.delivery.api.domain.product.Product;
import com.delivery.api.usecase.dto.ProductCreateRequest;

import jakarta.persistence.EntityManager;

/**
 *
 * @author gabriel
 */
@DataJpaTest
@ActiveProfiles("test")
public class ProductRepositoryTest {

    @Autowired
    EntityManager entityManager;

    @Autowired
    ProductRepository productRepository;

    @Test
    @DisplayName("Should get product successfully")
    void findProductByCode() {
        String code = "BNN";
        ProductCreateRequest p = new ProductCreateRequest("Banana", 10L, 50, "BNN");
        this.createProduct(p);

        Optional<Product> result = this.productRepository.findByCode(code);
        assertThat(result).isPresent();
        assertThat(result.get().getName()).isEqualTo("Banana");
        assertThat(result.get().getCode()).isEqualTo("BNN");

    }

    private Product createProduct(ProductCreateRequest productCreateRequest) {
        Product newProduct = new Product();
        newProduct.setCode(productCreateRequest.code());
        newProduct.setName(productCreateRequest.name());
        newProduct.setPrice(productCreateRequest.price());
        newProduct.setStockQuantity(productCreateRequest.stockQuantity());

        this.entityManager.persist(newProduct);

        return newProduct;
    }

}