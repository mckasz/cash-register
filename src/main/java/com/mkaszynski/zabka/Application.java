package com.mkaszynski.zabka;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ProductDao productDao(ProductRepository productRepository) {
        return new DbProductDao(productRepository);
    }

    @Bean
    public CashRegistryDao cashRegistryDao(CashRegistryRepository cashRegistryRepository) {
        return new DbCashRegistryDao(cashRegistryRepository);
    }


//    @Bean
//    public ProductResource productResource(ProductDao productDao) {
//        return new ProductResource(new ProductService(productDao));
//    }

}
