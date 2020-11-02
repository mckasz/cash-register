package com.mkaszynski.zabka.domain;

import com.mkaszynski.zabka.db.LineItemEntity;
import com.mkaszynski.zabka.dto.LineItemDto;
import lombok.Getter;

@Getter
public class LineItem {
    private final String productName;
    private int amount;
    private final int unitPrice;

    public LineItem(String productName, int amount, int unitPrice) {
        this.productName = productName;
        this.amount = amount;
        this.unitPrice = unitPrice;
    }

    static LineItem firstLineItemFor(Product product) {
        return new LineItem(product.getName(), 1, product.getPrice());
    }

    public void increaseAmount() {
        amount += 1;
    }

    public int finalPrice() {
        return amount * unitPrice;
    }

    LineItemEntity toEntity() {
        return new LineItemEntity(productName, amount, unitPrice);
    }

    public LineItemDto toDto() {
        return new LineItemDto(productName, amount, unitPrice, finalPrice());
    }
}
