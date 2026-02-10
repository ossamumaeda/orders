package com.delivery.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.api.domain.order.Order;
import com.delivery.api.domain.orderItem.OrderItem;
import com.delivery.api.repositories.OrderItemRepository;
import com.delivery.api.usecase.dto.OrderItemCreateProduct;

@Service
public class OrderItemService {
    
    private final OrderItemRepository orderItemRepository;

    public OrderItemService(@Autowired OrderItemRepository orderItemRepository){
        this.orderItemRepository = orderItemRepository;
    }

    public List<OrderItem> createOrderItem(List<OrderItemCreateProduct> order_items, Order order){

        if(order_items.size() <= 0){
            return null;
        }

        List<OrderItem> items = new ArrayList<OrderItem>();
        for (OrderItemCreateProduct orderItem : order_items) {
            if (orderItem.product() == null) {
                continue;
            }

            if (orderItem.quantity() <= 0) {
                continue;
            }

            OrderItem item = new OrderItem();
            
            item.setOrder(order);
            item.setQuantity(orderItem.quantity());
            item.setProduct(orderItem.product());
            item.setPrice(orderItem.quantity() * orderItem.product().getPrice());

            items.add(item);
            this.orderItemRepository.save(item);
        }

        return items;

    }

}
