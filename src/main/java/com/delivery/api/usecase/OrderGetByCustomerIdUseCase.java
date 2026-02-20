package com.delivery.api.usecase;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.api.domain.customer.Customer;
import com.delivery.api.domain.order.Order;
import com.delivery.api.domain.orderItem.OrderItem;
import com.delivery.api.service.CustomerService;
import com.delivery.api.service.OrderService;
import com.delivery.api.usecase.dto.OrderGetByCustomerIdRequest;
import com.delivery.api.usecase.dto.OrderGetByIdItem;
import com.delivery.api.usecase.dto.OrderGetByIdResponse;

@Service
public class OrderGetByCustomerIdUseCase{

    private final OrderService orderService;
    private final CustomerService customerService;

    public OrderGetByCustomerIdUseCase(
            @Autowired OrderService orderService,
            @Autowired CustomerService customerService) {
        this.orderService = orderService;
        this.customerService = customerService;
    }

    public List<OrderGetByIdResponse> execute(OrderGetByCustomerIdRequest orderGetByCustomerIdRequest) {

        if (orderGetByCustomerIdRequest.customer_id() == null) {
            throw new RuntimeException("Customer id was no informed");
        }

        Customer customer = this.customerService.findCustomerByCode(orderGetByCustomerIdRequest.customer_id());

        if(customer == null){
            return null;
        }

        List<Order> orders = this.orderService.getOrderByCustomer(customer);

        if (orders.size() < 0) {
            return null;
        }

        List<OrderGetByIdResponse> response = new ArrayList<OrderGetByIdResponse>();

        for (Order order : orders) {

            List<OrderGetByIdItem> items = new ArrayList<OrderGetByIdItem>();
            for (OrderItem item : order.getItems()) {
                OrderGetByIdItem itemResponse = new OrderGetByIdItem(item.getQuantity(), item.getPrice());
                items.add(itemResponse);
            }

            OrderGetByIdResponse r = new OrderGetByIdResponse(order.getStatus_order(),
                    order.getCreated_at(),
                    order.getCustomer().getName(),
                    order.getCustomer().getEmail(),
                    items);
            response.add(r);
        }

        return response;

    }

}
