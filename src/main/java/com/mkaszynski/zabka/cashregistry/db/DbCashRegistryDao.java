package com.mkaszynski.zabka.cashregistry.db;

import static java.util.stream.Collectors.toList;

import com.mkaszynski.zabka.cashregistry.domain.CashRegistry;
import com.mkaszynski.zabka.cashregistry.domain.CashRegistryDao;
import com.mkaszynski.zabka.cashregistry.domain.LineItem;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

class DbCashRegistryDao implements CashRegistryDao {

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
        cashRegistryRepository.save(toEntity(cashRegistry));
    }

    private CashRegistryEntity toEntity(CashRegistry cashRegistry) {
        return new CashRegistryEntity(cashRegistry.getId(), cashRegistry.getLineItems().values()
                                                                        .stream()
                                                                        .map(this::toEntity)
                                                                        .collect(toList()));
    }

    public LineItemEntity toEntity(LineItem lineItem) {
        return new LineItemEntity(lineItem.getProductName(),
                                  lineItem.getAmount(),
                                  lineItem.getUnitPrice());
    }
}
