package com.mkaszynski.zabka;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

import static java.util.stream.Collectors.toList;

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
