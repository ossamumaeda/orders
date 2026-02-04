package com.delivery.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.delivery.api.domain.customer.Customer;
import com.delivery.api.repositories.CustomerRepository;
import com.delivery.api.service.dto.CustomerCreateRequest;
import com.delivery.api.service.dto.CustomerCreateResponse;

@Service
public class CustomerService {
    
    private final CustomerRepository customerRepository;

    public CustomerService(@Autowired CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public ResponseEntity<CustomerCreateResponse> createCustomer(CustomerCreateRequest customerCreateRequest){
        
        if(customerCreateRequest.email() == null || customerCreateRequest.name() == null){
            return ResponseEntity.badRequest().body(null);
        }

        Customer customer = new Customer(customerCreateRequest.name(),customerCreateRequest.email());
        
        customer = this.customerRepository.save(customer);

        CustomerCreateResponse response = new CustomerCreateResponse(customer.getEmail(), customer.getName(), customer.getId());

        return ResponseEntity.ok().body(response);
    }

}
