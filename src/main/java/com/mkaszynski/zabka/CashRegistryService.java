package com.mkaszynski.zabka;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class CashRegistryService {
    private final ProductDao productDao;
    private final CashRegistryDao cashRegistryDao;
    private final PaymentGateway paymentGateway;

    public CashRegistryDto scanProduct(int id, String name) {
        Product product = productDao.find(name);

        CashRegistry cashRegistry = cashRegistryDao.getOrCreate(id);
        cashRegistry.addProduct(product);
        cashRegistryDao.save(cashRegistry);

        return cashRegistry.toDto();
    }

    public CashRegistryDto get(int id) {
        CashRegistry cashRegistry = cashRegistryDao.getOrCreate(id);
        return cashRegistry.toDto();
    }

    public CashRegistryDto checkout(int id) {
        CashRegistry cashRegistry = cashRegistryDao.getOrCreate(id);
        paymentGateway.takePayment(cashRegistry.totalPrice());
        cashRegistry.clear();
        cashRegistryDao.save(cashRegistry);
        return cashRegistry.toDto();
    }
}
