package com.delivery.api.service;

import java.util.Optional;
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

        Optional<Customer> customer = this.customerRepository.findById(customer_id);
        if (customer.isPresent() == false) {
            return null;
        }

        return customer.get();

    }

}
