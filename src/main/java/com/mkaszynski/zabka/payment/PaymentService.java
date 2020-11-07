package com.mkaszynski.zabka.payment;

public class PaymentService implements PaymentGateway {

    @Override
    public void takePayment(int value) {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
