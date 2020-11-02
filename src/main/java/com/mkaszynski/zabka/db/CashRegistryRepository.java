package com.mkaszynski.zabka.db;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CashRegistryRepository extends JpaRepository<CashRegistryEntity, Integer> {
}
