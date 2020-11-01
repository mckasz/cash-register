package com.mkaszynski.zabka;

import lombok.Getter;

@Getter
class LineItem {
    private String productName;
    private int amount;
    private int unitPrice;
    private String imagePath;

    public LineItem(String productName, int amount, int unitPrice, String imagePath) {
        this.productName = productName;
        this.amount = amount;
        this.unitPrice = unitPrice;
        this.imagePath = imagePath;
    }

    static LineItem firstLineItemFor(Product product) {
        return new LineItem(product.getName(), 1, product.getPrice(), product.getImagePath());
    }

    public void increaseAmount() {
        amount += 1;
    }

    public int finalPrice() {
        return amount * unitPrice;
    }

    LineItemEntity toEntity() {
        return new LineItemEntity(productName, amount, unitPrice, imagePath);
    }

    public LineItemDto toDto() {
        return new LineItemDto(productName, amount, unitPrice, finalPrice(), imagePath);
    }
}
