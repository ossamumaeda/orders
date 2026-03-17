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
    void whenProductIsCreatedSuccesfully() {

        ProductCreateRequest input = new ProductCreateRequest("Teste", 13L, 10, "ABC");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        RestClient restClient = restClientBuilder.baseUrl("http://localhost:" + port + "/").build();
        String body = restClient.post()
                .uri("product/create-product")
                .retrieve()
                .body(String.class);

        assertThat(body).isEqualTo("expected");
        // Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        // Assertions.assertEquals(sorted, response.getBody());

    }

}
