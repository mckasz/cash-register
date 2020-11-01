package com.mkaszynski.zabka;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "product")
class ProductEntity {
    @Id
    private String name;
    private int amount;
    private int price;
    private String imagePath;

    public ProductEntity() {
    }

    public ProductEntity(String name, int amount, int price, String imagePath) {
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.imagePath = imagePath;
    }

    Product toDomain() {
        return new Product(name, amount, price, imagePath);
    }
}
