package com.delivery.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiApplicationTests {

	@Test
	@DisplayName("2 + 3 = 5")
    void deveSomarDoisNumeros() {
        int resultado = 2 + 3;

        assertEquals(5, resultado);
    }

}
