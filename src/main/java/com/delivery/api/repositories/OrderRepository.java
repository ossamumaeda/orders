package com.delivery.api.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.delivery.api.domain.customer.Customer;
import com.delivery.api.domain.order.Order;


public interface OrderRepository extends JpaRepository<Order, UUID>{

    @EntityGraph(attributePaths = {"items","customer"})
    @Query("SELECT o FROM Order o")
    Order getReferenceById(UUID id);

    @EntityGraph(attributePaths = {"items","customer"})
    @Query("SELECT o FROM Order o")
    List<Order> getRefenceByCustomer(Customer customer);

}
