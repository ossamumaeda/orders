package com.delivery.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.delivery.api.domain.customer.Customer;
import com.delivery.api.repositories.CustomerRepository;

@Service
public class CustomerService {
    
    private final CustomerRepository customerRepository;

    public CustomerService(@Autowired CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public ResponseEntity<Customer> createCustomer(CustomerCreateRequest customerCreateRequest){
        if(customerCreateRequest.email() == null || customerCreateRequest.name() == null){
            return ResponseEntity.badRequest().body(null);
        }
        Customer customer = new Customer(customerCreateRequest.name(),customerCreateRequest.email());
        
        this.customerRepository.save(customer);

        return ResponseEntity.ok().body(customer);
    }

}
