package com.delivery.api.controller;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestClient;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.delivery.api.usecase.dto.ProductCreateRequest;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductIT {

    @Autowired
    private MockMvc mockMvc;

    @LocalServerPort
    private int port;

    // @Autowired
    // private TestRestTemplate restTemplate;
    // private final TestRestTemplate restTemplate = new TestRestTemplate();
    @Autowired
    private RestClient.Builder restClientBuilder;

    @Test
    void whenProductIsCreatedSuccesfully() throws Exception {

        // ProductCreateRequest input = new ProductCreateRequest("Teste", 13L, 10, "ABC");
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

    }

}
