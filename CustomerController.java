package com.delivery.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.api.usecase.CustomerCreateUseCase;
import com.delivery.api.usecase.dto.CustomerCreateRequest;
import com.delivery.api.usecase.dto.CustomerCreateResponse;


@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
    
    private final CustomerCreateUseCase customerCreateUseCase;

    public CustomerController(@Autowired CustomerCreateUseCase customerCreateUseCase){
        this.customerCreateUseCase = customerCreateUseCase;
    }

    @PostMapping("/create-customer")
    public ResponseEntity<CustomerCreateResponse> postMethodName(@RequestBody CustomerCreateRequest customerCreateRequest) {
        
        CustomerCreateResponse response = this.customerCreateUseCase.execute(customerCreateRequest);

        return ResponseEntity.ok(response);
        
    }
    

}
