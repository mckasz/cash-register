package com.mkaszynski.zabka.domain;

import static com.mkaszynski.zabka.domain.LineItem.firstLineItemFor;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

import com.mkaszynski.zabka.db.CashRegistryEntity;
import com.mkaszynski.zabka.dto.CashRegistryDto;
import com.mkaszynski.zabka.dto.LineItemDto;
import java.util.List;
import java.util.Map;

public class CashRegistry {
    private final int id;
    private final Map<String, LineItem> lineItems;
    private String unused;

    public CashRegistry(int id, List<LineItem> lineItems) {
        this.id = id;
        this.lineItems = lineItems.stream().collect(toMap(LineItem::getProductName, identity()));
    }

    public void addProduct(Product product) {
        LineItem lineItem = lineItems.get(product.getName());
        if (lineItem == null) {
            lineItems.put(product.getName(), firstLineItemFor(product));
        } else {
            LineItem updatedLineItem = lineItem.increaseAmount();
            lineItems.put(product.getName(), updatedLineItem);
        }
    }

    private List<LineItemDto> mapLineItems() {
        return lineItems.values()
                        .stream()
                        .map(LineItem::toDto)
                        .collect(toList());
    }

    public void clear() {
        lineItems.clear();
    }

    public int totalPrice() {
        return lineItems.values()
                        .stream()
                        .mapToInt(LineItem::finalPrice)
                        .sum();
    }

    public CashRegistryDto toDto() {
        return new CashRegistryDto(id,
                                   mapLineItems(),
                                   totalPrice());
    }

    public CashRegistryEntity toEntity() {
        return new CashRegistryEntity(id, lineItems.values()
                                                   .stream()
                                                   .map(LineItem::toEntity)
                                                   .collect(toList()));
    }
}
