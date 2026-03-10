package com.delivery.api.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.delivery.api.domain.product.Product;
import com.delivery.api.exceptions.jpaExceptions.ProductAlreadyExistsException;
import com.delivery.api.repositories.ProductRepository;
import com.delivery.api.service.ProductService;
import com.delivery.api.usecase.dto.ProductCreateRequest;

public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreateProductWhenRequestBodyIsValid() {

        // Given
        ProductCreateRequest productCreateRequest = new ProductCreateRequest(
                "Lata refrigerante",
                3L,
                10,
                "SODACAN");

        // When
        when(productRepository.save(any())).thenAnswer(i -> i.getArgument(0));
        Product response = productService.createProduct(productCreateRequest);

        // Then
        assertNotNull(response);

    }

    @Test
    void shouldNotCreateProductWhenBodyIsInvalid() {

        ProductCreateRequest productCreateRequest = new ProductCreateRequest(
                "Lata refrigerante",
                null,
                10,
                "SODACAN");

        Product response = productService.createProduct(productCreateRequest);

        assertNull(response);

    }

    @Test
    void shouldCreateProductWithStockZeroWhenNotInformedInBody() {

        ProductCreateRequest productCreateRequest = new ProductCreateRequest(
                "Lata refrigerante",
                3L,
                null,
                "SODACAN");

        when(productRepository.save(any())).thenAnswer(i -> i.getArgument(0));
        Product response = productService.createProduct(productCreateRequest);

        // Then
        assertEquals(0, response.getStockQuantity());
    }

    @Test
    void ShouldThrowErrorWhenProductExists() {

        ProductCreateRequest productCreateRequest = new ProductCreateRequest(
                "Lata refrigerante",
                3L,
                null,
                "SODACAN");

        when(productRepository.save(any())).thenThrow(ProductAlreadyExistsException.class);

        // Then
        assertThrows(ProductAlreadyExistsException.class,
                () -> productService.createProduct(productCreateRequest));

    }

}
