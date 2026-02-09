package com.delivery.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.api.service.OrderService;
import com.delivery.api.service.dto.OrderCreateRequest;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(@Autowired OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping("/create-order")
    public ResponseEntity<Object> postMethodName(@RequestBody OrderCreateRequest orderCreateRequest) {
        
        return this.orderService.createOrderWithItems(orderCreateRequest);
        
    }

}
