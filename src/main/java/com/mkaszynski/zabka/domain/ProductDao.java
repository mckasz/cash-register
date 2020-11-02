package com.mkaszynski.zabka.domain;

public interface ProductDao {
    Product find(String name);

    void save(Product product);
}
