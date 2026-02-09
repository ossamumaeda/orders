package com.delivery.api.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.delivery.api.domain.customer.Customer;
import com.delivery.api.domain.order.Order;
import com.delivery.api.domain.orderItem.OrderItem;
import com.delivery.api.domain.product.Product;
import com.delivery.api.repositories.CustomerRepository;
import com.delivery.api.repositories.OrderItemRepository;
import com.delivery.api.repositories.OrderRepository;
import com.delivery.api.repositories.ProductRepository;
import com.delivery.api.service.dto.OrderCreateRequest;
import com.delivery.api.service.dto.OrderItemCreateRequest;

@Service
public class OrderService {

    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public OrderService(@Autowired OrderItemRepository orderItemRepository,
            @Autowired OrderRepository orderRepository,
            @Autowired CustomerRepository customerRepository,
            @Autowired ProductRepository productRepository) {
        this.orderItemRepository = orderItemRepository;
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    public ResponseEntity<Object> createOrderWithItems(OrderCreateRequest orderCreateRequest) {

        if (orderCreateRequest.customer_id() == null) {
            return ResponseEntity.badRequest().body(null);
        }

        if (orderCreateRequest.order_items().size() < 0) {
            return ResponseEntity.badRequest().body(null);
        }

        // Primeiro criar uma order com o customer
        Customer customer = this.customerRepository.getReferenceById(orderCreateRequest.customer_id());
        if (customer == null) {
            return ResponseEntity.badRequest().body(null);
        }

        Order order = new Order();
        order.setCreated_at(Instant.now());
        order.setCustomer(customer);
        order.setStatus_order("Novo");

        order = this.orderRepository.save(order);



        HashSet<OrderItem> orderItems = new HashSet<OrderItem>();
        for (OrderItemCreateRequest orderItem : orderCreateRequest.order_items()) {
            if (orderItem.code() == null) {
                continue;
            }

            if (orderItem.quantity() < 0) {
                continue;
            }

            Product product = this.productRepository.findByCode(orderItem.code()).orElseThrow();
            System.out.println(product);
            OrderItem item = new OrderItem();
            item.setOrder(order);
            item.setQuantity(orderItem.quantity());
            item.setProduct(product);
            item.setPrice(orderItem.quantity() * product.getPrice());

            orderItems.add(item);
            this.orderItemRepository.save(item);
        }

        order.setItems(orderItems); 

        return ResponseEntity.ok(order);

    }

}
