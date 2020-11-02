package com.mkaszynski.zabka.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineItemTest {

    @Test
    void shouldKeepOriginalPriceForTwoProducts() {
        LineItem lineItem = new LineItem("name", 1, 100);

        LineItem result = lineItem.increaseAmount();

        assertThat(result).isEqualTo(new LineItem("name", 2, 100));
        assertThat(result.finalPrice()).isEqualTo(200);
        assertThat(lineItem.toDto().getPromotion()).isEqualTo("");
    }

    @Test
    void shouldAddOneProductForFreeForThreeProducts() {
        LineItem lineItem = new LineItem("name", 2, 100);

        LineItem result = lineItem.increaseAmount();

        assertThat(result).isEqualTo(new LineItem("name", 3, 100));
        assertThat(result.finalPrice()).isEqualTo(200);
        assertThat(result.toDto().getPromotion()).isEqualTo("3 for 2");
    }

    @Test
    void shouldAddOneProductForFreeForFourProducts() {
        LineItem lineItem = new LineItem("name", 3, 100);

        LineItem result = lineItem.increaseAmount();

        assertThat(result).isEqualTo(new LineItem("name", 4, 100));
        assertThat(result.finalPrice()).isEqualTo(300);
        assertThat(lineItem.toDto().getPromotion()).isEqualTo("3 for 2");
    }

    @Test
    void shouldAddTwoProductsForFreeForSixProducts() {
        LineItem lineItem = new LineItem("name", 6, 100);
        assertThat(lineItem.finalPrice()).isEqualTo(400);
        assertThat(lineItem.toDto().getPromotion()).isEqualTo("3 for 2");
    }
}