package com.delivery.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	//mvn flyway:migrate
	// mvn flyway:migrate   -Dflyway.url=jdbc:postgresql://localhost:5432/orders   -Dflyway.user=admin   -Dflyway.password=adminpassword

}
