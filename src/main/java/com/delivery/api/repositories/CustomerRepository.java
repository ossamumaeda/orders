package com.delivery.api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delivery.api.domain.customer.Customer;

public interface CustomerRepository extends JpaRepository<Customer, UUID>{
    
}
