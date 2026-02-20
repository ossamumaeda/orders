package com.delivery.api.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.api.domain.customer.Customer;
import com.delivery.api.domain.order.Order;
import com.delivery.api.exceptions.runTimeExceptions.NoCustumerException;
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
            return null;
        }

        Optional<Order> order = this.orderRepository.findById(order_id);
        if(order.isPresent() == false){
            return null;
        }

        return order.get();
    }

    public List<Order> getOrderByCustomer(Customer customer){

        if(customer == null){
            return null;
        }
        
        List<Order> orders = this.orderRepository.getRefenceByCustomer(customer);
        
        return orders;

    }


}
