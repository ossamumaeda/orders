package com.delivery.api.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.api.domain.customer.Customer;
import com.delivery.api.service.CustomerService;
import com.delivery.api.usecase.dto.CustomerCreateRequest;
import com.delivery.api.usecase.dto.CustomerCreateResponse;

@Service
public class CustomerCreateUseCase {
    
    private final CustomerService customerService;

    public CustomerCreateUseCase(@Autowired CustomerService customerService){
        this.customerService = customerService;
    }

    public CustomerCreateResponse execute(CustomerCreateRequest customerCreateRequest){
        
        Customer customer = this.customerService.createCustomer(customerCreateRequest);
        
        if(customer == null){
            return null;
        }

        CustomerCreateResponse response = new CustomerCreateResponse(
            customer.getName(), customer.getEmail(), customer.getId()
        );

        return response;
    }

}
