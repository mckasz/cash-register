package com.mkaszynski.zabka.cashregistry.db;

import org.springframework.data.jpa.repository.JpaRepository;

interface CashRegistryRepository extends JpaRepository<CashRegistryEntity, Integer> {
}
