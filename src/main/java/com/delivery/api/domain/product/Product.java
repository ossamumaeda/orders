package com.delivery.api.domain.product;

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
@Table(name = "product")
@Entity
public class Product {

    @Id
    @GeneratedValue // Gera um valor automatico
    private UUID id;

    private String name;

    private Long price;

    private Integer stockQuantity;

    private String code;

    @Override
    public boolean equals(Object o) {

        if (o == this) {
            return true;
        }

        if (!(o instanceof Product)) {
            return false;
        }

        Product product = (Product) o;

        return this.code.equals(product.code);

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (code == null ? 0 : code.hashCode());
        return hash;
    }

}
