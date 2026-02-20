package com.delivery.api.domain.order;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import com.delivery.api.domain.customer.Customer;
import com.delivery.api.domain.orderItem.OrderItem;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
        fetch = FetchType.LAZY
    )
    // @JsonManagedReference
    private List<OrderItem> items;


    // @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "payment_id", referencedColumnName = "id")
    // private Payment payment;

}
