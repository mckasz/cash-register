package com.mkaszynski.zabka;

class PaymentService implements PaymentGateway {
    @Override
    public void takePayment(int value) {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
