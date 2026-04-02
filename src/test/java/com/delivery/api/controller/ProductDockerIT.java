package com.delivery.api.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.flywaydb.core.Flyway;

import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;

import com.delivery.api.repositories.ProductRepository;

import jakarta.transaction.Transactional;

import org.springframework.context.annotation.Import;

import org.junit.jupiter.api.TestInstance;

@SpringBootTest
@AutoConfigureMockMvc
@Testcontainers
@Transactional // rollback after each test (clean DB automatically)
@ActiveProfiles("testintegration")
@Import(TestConfig.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProductDockerIT {

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15")
            .withDatabaseName("testdb")
            .withUsername("test")
            .withPassword("test")
            .withReuse(true); // 🚀 faster tests

    @Autowired(required = false)
    public Flyway flyway;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductRepository repository;

    @BeforeAll
    void setupDatabase() {
        flyway.migrate();
    }

    @BeforeEach
    void clean() {
        repository.deleteAll();
    }

    @Test
    void shouldCreateProduct() throws Exception {
        String json = """
        {
            "name": "Teste",
            "price": 13,
            "code": "ABC123545",
            "stockQuantity":10
        }
        """;

        mockMvc.perform(post("/product/create-product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().is(200));

        assertThat(repository.count() == 1);
    }


}