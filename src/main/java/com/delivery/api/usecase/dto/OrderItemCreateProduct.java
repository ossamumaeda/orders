package com.delivery.api.usecase.dto;

import com.delivery.api.domain.product.Product;

public record OrderItemCreateProduct(
        Product product,
        Integer quantity) {

    @Override
    public boolean equals(Object o) {

        if (o == this) {
            return true;
        }

        if (!(o instanceof OrderItemCreateProduct)) {
            return false;
        }

        OrderItemCreateProduct orderItemCreateProduct = (OrderItemCreateProduct) o;

        return this.product.equals(orderItemCreateProduct.product);
    }

}
