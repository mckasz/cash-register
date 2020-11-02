package com.mkaszynski.zabka;


import com.mkaszynski.zabka.db.CashRegistryRepository;
import com.mkaszynski.zabka.db.DbCashRegistryDao;
import com.mkaszynski.zabka.db.DbProductDao;
import com.mkaszynski.zabka.db.ProductRepository;
import com.mkaszynski.zabka.domain.CashRegistryDao;
import com.mkaszynski.zabka.domain.ProductDao;
import com.mkaszynski.zabka.payment.PaymentGateway;
import com.mkaszynski.zabka.payment.PaymentService;
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

    @Bean
    PaymentGateway paymentGateway() {
        return new PaymentService();
    }

}
