package com.mkaszynski.zabka;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "line_item")
class LineItemEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String productName;
    private int amount;
    private int price;
    private String imagePath;

    public LineItemEntity() {
    }

    public LineItemEntity(String productName, int amount, int price, String imagePath) {
        this.productName = productName;
        this.amount = amount;
        this.price = price;
        this.imagePath = imagePath;
    }

    public LineItem toDomain() {
        return new LineItem(productName, amount, price, imagePath);
    }
}
