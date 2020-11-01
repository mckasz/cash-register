package com.mkaszynski.zabka;

interface ProductDao {
    Product find(String name);

    void save(Product product);
}
