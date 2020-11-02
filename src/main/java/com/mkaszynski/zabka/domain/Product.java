package com.mkaszynski.zabka.domain;

import com.mkaszynski.zabka.db.ProductEntity;
import com.mkaszynski.zabka.dto.ProductDto;
import lombok.Getter;

@Getter
public class Product {
    private final String name;
    private final int amount;
    private final int price;

    public Product(String name, int amount, int price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public ProductDto toDto() {
        return new ProductDto(name, amount, price);
    }

    public ProductEntity toEntity() {
        return new ProductEntity(name, amount, price);
    }
}
