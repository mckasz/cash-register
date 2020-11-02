package com.mkaszynski.zabka.db;

import com.mkaszynski.zabka.domain.LineItem;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "line_item")
public class LineItemEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
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
