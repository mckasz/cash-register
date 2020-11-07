package com.mkaszynski.zabka.cashregistry.db;

import static java.util.stream.Collectors.toList;

import com.mkaszynski.zabka.cashregistry.domain.CashRegistry;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cash_registry")
class CashRegistryEntity {
    @Id
    private int id;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LineItemEntity> lineItemEntities;

    public CashRegistryEntity() {
    }

    public CashRegistryEntity(int id, List<LineItemEntity> lineItemEntities) {
        this.id = id;
        this.lineItemEntities = lineItemEntities;
    }

    CashRegistry toDomain() {
        return new CashRegistry(id, lineItemEntities.stream()
                                                    .map(LineItemEntity::toDomain)
                                                    .collect(toList()));
    }
}
