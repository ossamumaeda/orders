package com.delivery.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.api.usecase.OrderCreateUseCase;
import com.delivery.api.usecase.dto.OrderCreateRequest;
import com.delivery.api.usecase.dto.OrderCreateResponse;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    private final OrderCreateUseCase OrderCreateUseCase;

    public OrderController(@Autowired OrderCreateUseCase createOrderUseCase){
        this.OrderCreateUseCase = createOrderUseCase;
    }

    @PostMapping("/create-order")
    public ResponseEntity<OrderCreateResponse> postMethodName(@RequestBody OrderCreateRequest orderCreateRequest) {
        
        OrderCreateResponse response = this.OrderCreateUseCase.execute(orderCreateRequest);
        return ResponseEntity.ok(response);
    }

}
