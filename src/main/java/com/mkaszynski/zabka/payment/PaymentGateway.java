package com.mkaszynski.zabka.payment;

public interface PaymentGateway {
    void takePayment(int value);
}
