package com.mkaszynski.zabka.cashregistry.domain;

import static com.mkaszynski.zabka.cashregistry.domain.LineItem.firstLineItemFor;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

import com.mkaszynski.zabka.cashregistry.dto.CashRegistryDto;
import com.mkaszynski.zabka.cashregistry.dto.LineItemDto;
import java.util.List;
import java.util.Map;

public class CashRegistry {
    private final int id;
    private final Map<String, LineItem> lineItems;

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

    public int getId() {
        return id;
    }

    public Map<String, LineItem> getLineItems() {
        return lineItems;
    }
}
