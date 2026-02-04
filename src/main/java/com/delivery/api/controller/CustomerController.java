package com.delivery.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.api.service.CustomerService;
import com.delivery.api.service.dto.CustomerCreateRequest;
import com.delivery.api.service.dto.CustomerCreateResponse;


@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
    
    private final CustomerService customerService;

    public CustomerController(@Autowired CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping("/create-customer")
    public ResponseEntity<CustomerCreateResponse> postMethodName(@RequestBody CustomerCreateRequest customerCreateRequest) {
        
        return this.customerService.createCustomer(customerCreateRequest);
        
    }
    

}
