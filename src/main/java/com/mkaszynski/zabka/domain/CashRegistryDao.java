package com.mkaszynski.zabka.domain;

public interface CashRegistryDao {
    CashRegistry getOrCreate(int id);

    void save(CashRegistry cashRegistry);
}
