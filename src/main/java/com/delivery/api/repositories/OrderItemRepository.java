package com.delivery.api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delivery.api.domain.orderItem.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, UUID>{
    
}
