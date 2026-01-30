package com.delivery.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.api.service.CustomerService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.delivery.api.service.CustomerCreateRequest;
import com.delivery.api.domain.customer.Customer;


@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
    
    private final CustomerService customerService;

    public CustomerController(@Autowired CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping("/create-customer")
    public ResponseEntity<Customer> postMethodName(@RequestBody CustomerCreateRequest customerCreateRequest) {
        
        return this.customerService.createCustomer(customerCreateRequest);
        
    }
    

}
