package com.mkaszynski.zabka;


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
    PaymentGateway paymentGateway() {
        return new PaymentService();
    }

}
