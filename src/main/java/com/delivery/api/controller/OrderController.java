package com.delivery.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.api.usecase.CreateOrderUseCase;
import com.delivery.api.usecase.dto.OrderCreateRequest;
import com.delivery.api.usecase.dto.OrderCreateResponse;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    private final CreateOrderUseCase createOrderUseCase;

    public OrderController(@Autowired CreateOrderUseCase createOrderUseCase){
        this.createOrderUseCase = createOrderUseCase;
    }

    @PostMapping("/create-order")
    public ResponseEntity<OrderCreateResponse> postMethodName(@RequestBody OrderCreateRequest orderCreateRequest) {
        
        OrderCreateResponse response = this.createOrderUseCase.execute(orderCreateRequest);
        return ResponseEntity.ok(response);
    }

}
