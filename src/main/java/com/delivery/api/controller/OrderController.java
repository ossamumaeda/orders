package com.delivery.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.api.usecase.OrderCreateUseCase;
import com.delivery.api.usecase.OrderGetByCustomerIdUseCase;
import com.delivery.api.usecase.OrderSearchByIdUseCase;
import com.delivery.api.usecase.dto.OrderCreateRequest;
import com.delivery.api.usecase.dto.OrderCreateResponse;
import com.delivery.api.usecase.dto.OrderGetByCustomerIdRequest;
import com.delivery.api.usecase.dto.OrderGetByIdRequest;
import com.delivery.api.usecase.dto.OrderGetByIdResponse;


@RestController
@RequestMapping(value = "/order")
public class OrderController {

    private final OrderCreateUseCase orderCreateUseCase;
    private final OrderSearchByIdUseCase orderSearchByIdUseCase;
    private final OrderGetByCustomerIdUseCase orderGetByCustomerIdUseCase;

    public OrderController(
            @Autowired OrderCreateUseCase createOrderUseCase,
            @Autowired OrderSearchByIdUseCase orderSearchByIdUseCase,
            @Autowired OrderGetByCustomerIdUseCase orderGetByCustomerIdUseCase
    ) {
        this.orderCreateUseCase = createOrderUseCase;
        this.orderSearchByIdUseCase = orderSearchByIdUseCase;
        this.orderGetByCustomerIdUseCase = orderGetByCustomerIdUseCase;
    }

    @PostMapping("/create-order")
    public ResponseEntity<OrderCreateResponse> postMethodName(@RequestBody OrderCreateRequest orderCreateRequest) {

        OrderCreateResponse response = this.orderCreateUseCase.execute(orderCreateRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get-order")
    public ResponseEntity<OrderGetByIdResponse> getOrderById(@RequestBody OrderGetByIdRequest orderGetByIdRequest) {
        OrderGetByIdResponse response = this.orderSearchByIdUseCase.execute(orderGetByIdRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get-order-customer")
    public ResponseEntity<List<OrderGetByIdResponse>> getOrderByCustomerId(@RequestBody OrderGetByCustomerIdRequest orderGetByCustomerIdRequest) {
        List<OrderGetByIdResponse> response = this.orderGetByCustomerIdUseCase.execute(orderGetByCustomerIdRequest);
        return ResponseEntity.ok(response);
    }

}
