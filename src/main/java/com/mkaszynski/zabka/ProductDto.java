package com.mkaszynski.zabka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class ProductDto {
    private String name;
    private int amount;
    private int price;
    private String imagePath;
}
