package com.mkaszynski.zabka.cashregistry.db;

import com.mkaszynski.zabka.cashregistry.domain.Product;
import com.mkaszynski.zabka.cashregistry.domain.ProductDao;
import java.util.Optional;

class DbProductDao implements ProductDao {
    private final ProductRepository repository;

    public DbProductDao(ProductRepository repository) {
        this.repository = repository;
        this.save(new Product("milk", 1, 220));
        this.save(new Product("beer", 1, 450));
        this.save(new Product("butter", 1, 280));
    }

    @Override
    public Product find(String name) {
        Optional<ProductEntity> byId = repository.findById(name);
        return byId.get().toDomain();
    }

    @Override
    public void save(Product product) {
        repository.save(toEntity(product));
    }


    public ProductEntity toEntity(Product product) {
        return new ProductEntity(product.getName(), product.getAmount(), product.getPrice());
    }

}
