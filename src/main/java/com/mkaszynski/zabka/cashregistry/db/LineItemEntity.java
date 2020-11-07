package com.mkaszynski.zabka.cashregistry.db;

import com.mkaszynski.zabka.cashregistry.domain.LineItem;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "line_item")
@EqualsAndHashCode
class LineItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String productName;
    private int amount;
    private int price;

    public LineItemEntity() {
    }

    public LineItemEntity(String productName, int amount, int price) {
        this.productName = productName;
        this.amount = amount;
        this.price = price;
    }

    public LineItem toDomain() {
        return new LineItem(productName, amount, price);
    }
}
