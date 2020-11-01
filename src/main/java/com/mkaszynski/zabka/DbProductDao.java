package com.mkaszynski.zabka;

import java.util.Optional;

class DbProductDao implements ProductDao {
    private ProductRepository repository;

    public DbProductDao(ProductRepository repository) {
        this.repository = repository;
        this.save(new Product("milk", 1, 220, "milk.jpeg"));
        this.save(new Product("beer", 1, 450, "beer.jpeg"));
        this.save(new Product("butter", 1, 280, "butter.jpeg"));
    }

    @Override
    public Product find(String name) {
        Optional<ProductEntity> byId = repository.findById(name);
        return byId.get().toDomain();
    }

    @Override
    public void save(Product product) {
        repository.save(product.toEntity());
    }
}
