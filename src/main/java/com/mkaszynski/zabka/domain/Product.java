package com.mkaszynski.zabka.domain;

import com.mkaszynski.zabka.db.ProductEntity;
import com.mkaszynski.zabka.dto.ProductDto;
import lombok.Getter;

@Getter
public class Product {
    private final String name;
    private final int amount;
    private final int price;
    private final String imagePath;

    public Product(String name, int amount, int price, String imagePath) {
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.imagePath = imagePath;
    }

    public ProductDto toDto() {
        return new ProductDto(name, amount, price, imagePath);
    }

    public ProductEntity toEntity() {
        return new ProductEntity(name, amount, price, imagePath);
    }
}
