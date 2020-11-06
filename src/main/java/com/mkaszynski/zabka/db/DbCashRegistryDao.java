package com.mkaszynski.zabka.db;

import com.mkaszynski.zabka.domain.CashRegistry;
import com.mkaszynski.zabka.domain.CashRegistryDao;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class DbCashRegistryDao implements CashRegistryDao {

    private final CashRegistryRepository cashRegistryRepository;

    public DbCashRegistryDao(CashRegistryRepository cashRegistryRepository) {
        this.cashRegistryRepository = cashRegistryRepository;
    }

    @Override
    public CashRegistry getOrCreate(int id) {
        List<CashRegistryEntity> cashRegistries = cashRegistryRepository.findAll();
        Optional<CashRegistryEntity> first =
            cashRegistries.stream().filter(c -> c.getId() == id).findFirst();
        if (first.isPresent()) {
            return first.get().toDomain();
        } else {
            return createEntity(id).toDomain();
        }
    }

    private CashRegistryEntity createEntity(int id) {
        CashRegistryEntity entity = new CashRegistryEntity(id, Collections.emptyList());
        cashRegistryRepository.save(entity);
        return entity;
    }

    @Override
    public void save(CashRegistry cashRegistry) {
        CashRegistryEntity s = cashRegistry.toEntity();
        cashRegistryRepository.save(s);
    }
}
