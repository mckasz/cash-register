package com.mkaszynski.zabka.domain;

import com.mkaszynski.zabka.db.LineItemEntity;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineItemTest {

    @Test
    void shouldThrowExceptionWhenAmountIsNotPositive() {
        assertThatThrownBy(() -> new LineItem("name", 0, 100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Line Item should have positive amount. Amount: 0");
        assertThatThrownBy(() -> new LineItem("name", -1, 100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Line Item should have positive amount. Amount: -1");
    }

    @Test
    void testPromotion() {
        assertThat(new LineItem("name", 1, 100).toDto().getPromotion()).isEqualTo("");
        assertThat(new LineItem("name", 2, 100).toDto().getPromotion()).isEqualTo("");
        assertThat(new LineItem("name", 3, 100).toDto().getPromotion()).isEqualTo("3 for 2");
        assertThat(new LineItem("name", 4, 100).toDto().getPromotion()).isEqualTo("3 for 2");
    }

    @Test
    void testEquality() {
        assertThat(new LineItem("name", 1, 100)).isNotEqualTo(new Object());
        assertThat(new LineItem("name", 1, 100)).isNotEqualTo(new LineItem("name1", 1, 100));
        assertThat(new LineItem("name", 1, 100)).isNotEqualTo(new LineItem("name", 2, 100));
        assertThat(new LineItem("name", 1, 100)).isNotEqualTo(new LineItem("name", 1, 200));
        assertThat(new LineItem("name", 1, 100).hashCode()).isNotEqualTo(new Object().hashCode());
        assertThat(new LineItem("name", 1, 100).hashCode()).isNotEqualTo(new LineItem("name1", 1, 100).hashCode());
        assertThat(new LineItem("name", 1, 100).hashCode()).isNotEqualTo(new LineItem("name", 2, 100).hashCode());
        assertThat(new LineItem("name", 1, 100).hashCode()).isNotEqualTo(new LineItem("name", 1, 200).hashCode());
    }

    @Test
    void testGetters() {
        assertThat(new LineItem("name", 1, 100).getProductName()).isEqualTo("name");
        assertThat(new LineItem("name", 1, 100).getAmount()).isEqualTo(1);
        assertThat(new LineItem("name", 1, 100).getUnitPrice()).isEqualTo(100);
    }

    @Test
    void testEntity() {
        assertThat(new LineItem("name", 1, 100).toEntity()).isEqualTo(new LineItemEntity("name", 1, 100));
    }

    @Test
    void shouldKeepOriginalPriceForTwoProducts() {
        LineItem lineItem = new LineItem("name", 1, 100);

        LineItem result = lineItem.increaseAmount();

        assertThat(result).isEqualTo(new LineItem("name", 2, 100));
        assertThat(result.finalPrice()).isEqualTo(200);
        assertThat(lineItem.toDto().getPromotion()).isEqualTo("");
    }

    @Test
    void shouldBeComparableByEquals() {
        LineItem lineItem = new LineItem("name", 1, 100);
        assertThat(lineItem).isEqualTo(new LineItem("name", 1, 100));
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