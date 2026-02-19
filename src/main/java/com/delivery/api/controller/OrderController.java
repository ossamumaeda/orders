package com.delivery.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.api.usecase.OrderCreateUseCase;
import com.delivery.api.usecase.OrderSearchByIdUseCase;
import com.delivery.api.usecase.dto.OrderCreateRequest;
import com.delivery.api.usecase.dto.OrderCreateResponse;
import com.delivery.api.usecase.dto.OrderGetByIdRequest;
import com.delivery.api.usecase.dto.OrderGetByIdResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value = "/order")
public class OrderController {

    private final OrderCreateUseCase orderCreateUseCase;
    private final OrderSearchByIdUseCase orderSearchByIdUseCase;

    public OrderController(@Autowired OrderCreateUseCase createOrderUseCase, @Autowired OrderSearchByIdUseCase orderSearchByIdUseCase){
        this.orderCreateUseCase = createOrderUseCase;
        this.orderSearchByIdUseCase = orderSearchByIdUseCase;
    }

    @PostMapping("/create-order")
    public ResponseEntity<OrderCreateResponse> postMethodName(@RequestBody OrderCreateRequest orderCreateRequest) {
        
        OrderCreateResponse response = this.orderCreateUseCase.execute(orderCreateRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get-order")
    public ResponseEntity<OrderGetByIdResponse> getMethodName(@RequestBody OrderGetByIdRequest orderGetByIdRequest) {
        OrderGetByIdResponse response = this.orderSearchByIdUseCase.execute(orderGetByIdRequest);
        return ResponseEntity.ok(response);
    }
    

}
