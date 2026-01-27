package com.delivery.api.domain.orderItem;

import java.util.UUID;

import com.delivery.api.domain.order.Order;
import com.delivery.api.domain.product.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_item")
@Entity
public class OrderItem {
    
    @Id
    @GeneratedValue // Gera um valor automatico
    private UUID id;

    private Integer quantity;

    private Long price;

    // Precisa se relacionar com 1 customer
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Override
    public boolean equals(Object o) {

        if (o == this) {
            return true;
        }

        if (!(o instanceof OrderItem)) {
            return false;
        }

        OrderItem orderItem = (OrderItem) o;

        return this.product.equals(orderItem.product);

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (product == null ? 0 : product.hashCode());
        return hash;
    }

}
