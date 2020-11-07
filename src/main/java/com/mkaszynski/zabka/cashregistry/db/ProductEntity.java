package com.mkaszynski.zabka.cashregistry.db;

import com.mkaszynski.zabka.cashregistry.domain.Product;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    private String name;
    private int amount;
    private int price;

    public ProductEntity() {
    }

    public ProductEntity(String name, int amount, int price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    Product toDomain() {
        return new Product(name, amount, price);
    }
}