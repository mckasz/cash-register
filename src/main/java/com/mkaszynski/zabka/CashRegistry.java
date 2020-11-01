package com.mkaszynski.zabka;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

class CashRegistry {
    private final int id;
    private final Map<String, LineItem> lineItems;

    public CashRegistry(int id, List<LineItem> lineItems) {
        this.id = id;
        this.lineItems = lineItems.stream().collect(Collectors.toMap(LineItem::getProductName, Function.identity()));
    }

    public void addProduct(Product product) {
        LineItem lineItem = lineItems.get(product.getName());
        if (lineItem == null) {
            lineItems.put(product.getName(), LineItem.firstLineItemFor(product));
        } else {
            lineItem.increaseAmount();
        }
    }

    public CashRegistryDto toDto() {
        return new CashRegistryDto(id,
                                   mapLineItems(),
                                   totalPrice());
    }

    private List<LineItemDto> mapLineItems() {
        return lineItems.values()
                        .stream()
                        .map(LineItem::toDto)
                        .collect(toList());
    }

    private int totalPrice() {
        return lineItems.values()
                        .stream()
                        .mapToInt(LineItem::finalPrice)
                        .sum();
    }

    public CashRegistryEntity toEntity() {
        return new CashRegistryEntity(id, lineItems.values()
                                                   .stream()
                                                   .map(LineItem::toEntity)
                                                   .collect(toList()));
    }
}
