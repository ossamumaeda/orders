package com.delivery.api.usecase;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.api.domain.customer.Customer;
import com.delivery.api.domain.order.Order;
import com.delivery.api.domain.orderItem.OrderItem;
import com.delivery.api.domain.product.Product;
import com.delivery.api.service.CustomerService;
import com.delivery.api.service.OrderItemService;
import com.delivery.api.service.OrderService;
import com.delivery.api.service.ProductService;
import com.delivery.api.usecase.dto.OrderCreateRequest;
import com.delivery.api.usecase.dto.OrderCreateResponse;
import com.delivery.api.usecase.dto.OrderItemCreateProduct;
import com.delivery.api.usecase.dto.OrderItemCreateRequest;
import com.delivery.api.usecase.dto.OrderItemCreateResponse;

import jakarta.transaction.Transactional;

@Service
public class OrderCreateUseCase {

    private final OrderService orderService;
    private final CustomerService customerService;
    private final ProductService productService;
    private final OrderItemService orderItemService;
    public OrderCreateUseCase(
            @Autowired OrderService orderService,
            @Autowired CustomerService customerService,
            @Autowired ProductService productService,
            @Autowired OrderItemService orderItemService
    ) {
        this.orderService = orderService;
        this.customerService = customerService;
        this.productService = productService;
        this.orderItemService = orderItemService;
    }

    @Transactional
    public OrderCreateResponse execute(OrderCreateRequest orderCreateRequest) {

        if (orderCreateRequest.customer_id() == null) {
            return null;
        }

        if(orderCreateRequest.order_items().size() <= 0){
            return null;
        }

        Customer customer = this.customerService.findCustomerByCode(orderCreateRequest.customer_id());
        // Create order
        Order order = this.orderService.CreateOrder(customer);
        System.out.println(order);
        List<OrderItemCreateProduct> items = new ArrayList<OrderItemCreateProduct>();
        for(OrderItemCreateRequest item : orderCreateRequest.order_items()){
            Product product = this.productService.getByCode(item.code());
            items.add(new OrderItemCreateProduct(product,item.quantity()));
        }

        List<OrderItem> orderItems = this.orderItemService.createOrderItem(items,order);
        List<OrderItemCreateResponse> itemsResponse = new ArrayList<OrderItemCreateResponse>();
        for(OrderItem o : orderItems){
            itemsResponse.add(new OrderItemCreateResponse(
                o.getPrice(),
                o.getQuantity(),
                o.getProduct().getName(),
                o.getProduct().getCode()
            ));
        }
        OrderCreateResponse orderCreateResponse = new OrderCreateResponse(
            order.getStatus_order(),
            order.getCreated_at(),
            customer.getName(),
            customer.getEmail(),
            itemsResponse
        );
        // Aqui sim eu deveria colocar um DTO
        return orderCreateResponse;

    }

}
