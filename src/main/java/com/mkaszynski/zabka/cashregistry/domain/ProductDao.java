package com.mkaszynski.zabka.cashregistry.domain;

public interface ProductDao {
    Product find(String name);

    void save(Product product);
}
