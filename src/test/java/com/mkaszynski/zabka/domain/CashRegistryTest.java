package com.mkaszynski.zabka.domain;

import com.mkaszynski.zabka.dto.LineItemDto;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class CashRegistryTest {

    @Test
    void name() {
        CashRegistry cashRegistry = new CashRegistry(1, Collections.emptyList());

        cashRegistry.addProduct(new Product("name", 1, 100));

        assertThat(cashRegistry.totalPrice()).isEqualTo(100);
        assertThat(cashRegistry.toDto().getLineItems()).containsOnly(new LineItemDto("name", 1, 100, 100, ""));
    }
}