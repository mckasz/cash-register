package com.mkaszynski.zabka;

interface CashRegistryDao {
    CashRegistry getOrCreate(int id);

    void save(CashRegistry cashRegistry);
}
