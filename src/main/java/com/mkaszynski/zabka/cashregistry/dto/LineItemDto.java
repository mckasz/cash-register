package com.mkaszynski.zabka.cashregistry.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LineItemDto {
    private String productName;
    private int amount;
    private int unitPrice;
    private int finalPrice;
    private String promotion;
}
