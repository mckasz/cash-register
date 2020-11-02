package com.mkaszynski.zabka.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CashRegistryDto {
    private int id;
    private List<LineItemDto> lineItems;
    private int totalPrice;
}
