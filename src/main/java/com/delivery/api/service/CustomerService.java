package com.delivery.api.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.api.domain.customer.Customer;
import com.delivery.api.repositories.CustomerRepository;
import com.delivery.api.usecase.dto.CustomerCreateRequest;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(@Autowired CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(CustomerCreateRequest customerCreateRequest) {

        if (customerCreateRequest.email() == null || customerCreateRequest.name() == null) {
            return null;
        }

        Customer customer = new Customer(customerCreateRequest.name(), customerCreateRequest.email());

        customer = this.customerRepository.save(customer);

        return customer;
    }

    public Customer findCustomerByCode(UUID customer_id) {
        if(customer_id == null){
            return null;
        }

        Customer customer = this.customerRepository.getReferenceById(customer_id);
        if (customer == null) {
            return null;
        }

        return customer;
    }

}
