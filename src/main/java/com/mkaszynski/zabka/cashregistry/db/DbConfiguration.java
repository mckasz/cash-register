package com.mkaszynski.zabka.cashregistry.db;

import com.mkaszynski.zabka.cashregistry.domain.CashRegistryDao;
import com.mkaszynski.zabka.cashregistry.domain.ProductDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class DbConfiguration {

    @Bean
    public CashRegistryDao cashRegistryDao(CashRegistryRepository cashRegistryRepository) {
        return new DbCashRegistryDao(cashRegistryRepository);
    }

    @Bean
    public ProductDao productDao(ProductRepository productRepository) {
        return new DbProductDao(productRepository);
    }

}
