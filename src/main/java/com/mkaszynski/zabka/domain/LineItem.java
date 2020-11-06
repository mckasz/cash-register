package com.mkaszynski.zabka.domain;

import com.mkaszynski.zabka.db.LineItemEntity;
import com.mkaszynski.zabka.dto.LineItemDto;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class LineItem {
    private final String productName;
    private final int amount;
    private final int unitPrice;

    public LineItem(String productName, int amount, int unitPrice) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Line Item should have positive amount. Amount: " + amount);
        }

        this.productName = productName;
        this.amount = amount;
        this.unitPrice = unitPrice;
    }

    static LineItem firstLineItemFor(Product product) {
        return new LineItem(product.getName(), 1, product.getPrice());
    }

    public LineItem increaseAmount() {
        return new LineItem(productName, amount + 1, unitPrice);
    }

    public int finalPrice() {
        return (amount - numberOfFreeItems()) * unitPrice;
    }

    private int numberOfFreeItems() {
        return amount / 3;
    }

    private String promotion() {
        return amount > 2 ? "3 for 2" : "";
    }

    LineItemEntity toEntity() {
        return new LineItemEntity(productName, amount, unitPrice);
    }

    public LineItemDto toDto() {
        return new LineItemDto(productName, amount, unitPrice, finalPrice(), promotion());
    }
}

