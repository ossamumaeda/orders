package com.delivery.api.usecase;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.api.service.OrderService;
import com.delivery.api.usecase.dto.OrderGetByIdItem;
import com.delivery.api.usecase.dto.OrderGetByIdRequest;
import com.delivery.api.usecase.dto.OrderGetByIdResponse;
import com.delivery.api.domain.order.Order;
import com.delivery.api.domain.orderItem.OrderItem;

@Service
public class OrderSearchByIdUseCase {

    private final OrderService orderService;

    public OrderSearchByIdUseCase(
            @Autowired OrderService orderService) {
        this.orderService = orderService;
    }

    public OrderGetByIdResponse execute(OrderGetByIdRequest orderGetByIdRequest) {

        if (orderGetByIdRequest.order_id() == null) {
            throw new RuntimeException("Id was no informed");
        }

        Order order = this.orderService.getOrder(orderGetByIdRequest.order_id());

        List<OrderGetByIdItem> items = new ArrayList<OrderGetByIdItem>();
        for (OrderItem item : order.getItems()) {
            OrderGetByIdItem itemResponse = new OrderGetByIdItem(item.getQuantity(), item.getPrice());
            items.add(itemResponse);
        }
        OrderGetByIdResponse response = new OrderGetByIdResponse(order.getStatus_order(),
                order.getCreated_at(),
                order.getCustomer().getName(),
                order.getCustomer().getEmail(),
                items);

        return response;

    }

}
