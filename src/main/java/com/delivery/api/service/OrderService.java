package com.delivery.api.service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

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

    public Order createOrder(Customer customer) {

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
 
    public Order getOrder(UUID order_id){

        if(order_id == null){
            throw new RuntimeException("No id was informed");
        }

        Order order = this.orderRepository.getReferenceById(order_id);
        return order;
    }

    public List<Order> getOrderByCustomer(Customer customer){

        if(customer == null){
            throw new RuntimeException("No customer id was informed");
        }

        List<Order> orders = this.orderRepository.getRefenceByCustomer(customer);
        
        return orders;

    }


}
