package com.delivery.api.service;

import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.api.domain.customer.Customer;
import com.delivery.api.domain.order.Order;
import com.delivery.api.repositories.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(@Autowired OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order CreateOrder(Customer customer) {

        if (customer == null) {
            return null;
        }

        Order order = new Order();
        order.setCreated_at(Instant.now());
        order.setCustomer(customer);
        order.setStatus_order("Novo");

        order = this.orderRepository.save(order);

        return order;
    }

}
