package com.mkaszynski.zabka.cashregistry.domain;

public interface CashRegistryDao {
    CashRegistry getOrCreate(int id);

    void save(CashRegistry cashRegistry);
}
