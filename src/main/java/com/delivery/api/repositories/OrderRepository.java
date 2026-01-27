package com.delivery.api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delivery.api.domain.order.Order;

public interface OrderRepository extends JpaRepository<Order, UUID>{
    
}
