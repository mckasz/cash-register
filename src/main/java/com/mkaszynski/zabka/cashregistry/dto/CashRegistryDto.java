package com.mkaszynski.zabka.cashregistry.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CashRegistryDto {
    private int id;
    private List<LineItemDto> lineItems;
    private int totalPrice;
}
