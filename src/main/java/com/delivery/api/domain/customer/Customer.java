package com.delivery.api.domain.customer;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
@Entity
public class Customer {

    @Id
    @GeneratedValue // Gera um valor automatico
    private UUID id;

    private String name;

    private String email;

    // @OneToMany(
    //     mappedBy = "customer",
    //     cascade = CascadeType.ALL,
    //     orphanRemoval = true
    // )
    // private HashSet<Order> order;

    public Customer(String name,String email){
        this.name = name;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) {
            return true;
        }

        if (!(o instanceof Customer)) {
            return false;
        }

        Customer customer = (Customer) o;

        return this.email.equals(customer.email);

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (email == null ? 0 : email.hashCode());
        return hash;
    }

}
