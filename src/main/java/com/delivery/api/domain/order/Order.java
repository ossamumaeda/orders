package com.delivery.api.domain.order;

import java.time.Instant;
import java.util.HashSet;
import java.util.UUID;

import com.delivery.api.domain.customer.Customer;
import com.delivery.api.domain.orderItem.OrderItem;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
@Entity
public class Order {

    @Id
    @GeneratedValue // Gera um valor automatico
    private UUID id;

    private String status_order;

    private Instant created_at;

    // Precisa se relacionar com 1 customer
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // @OneToMany(mappedBy = "order")
    @OneToMany( 
        mappedBy = "order",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private HashSet<OrderItem> items;


    // @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "payment_id", referencedColumnName = "id")
    // private Payment payment;

}
