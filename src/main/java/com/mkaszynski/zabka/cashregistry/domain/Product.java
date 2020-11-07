package com.mkaszynski.zabka.cashregistry.domain;

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
}
