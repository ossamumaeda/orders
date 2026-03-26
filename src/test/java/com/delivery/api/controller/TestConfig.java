package com.delivery.api.controller;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class TestConfig {
    @Bean
    public Flyway flyway(DataSource dataSource) {
        System.out.println("Creating Flyway bean");
        return Flyway.configure().dataSource(dataSource).locations("classpath:db/migration").load();
    }
}