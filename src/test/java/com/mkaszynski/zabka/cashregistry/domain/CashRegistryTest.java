package com.mkaszynski.zabka.cashregistry.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.mkaszynski.zabka.cashregistry.dto.LineItemDto;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class CashRegistryTest {

    @Test
    void name() {
        CashRegistry cashRegistry = new CashRegistry(1, Collections.emptyList());

        cashRegistry.addProduct(new Product("name", 1, 100));

        assertThat(cashRegistry.totalPrice()).isEqualTo(100);
        assertThat(cashRegistry.toDto().getLineItems()).containsOnly(new LineItemDto("name", 1, 100, 100, ""));
    }
}