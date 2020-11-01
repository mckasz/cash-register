package com.mkaszynski.zabka;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class LineItemDto {
    private String productName;
    private int amount;
    private int unitPrice;
    private int finalPrice;
    private String imagePath;
}
