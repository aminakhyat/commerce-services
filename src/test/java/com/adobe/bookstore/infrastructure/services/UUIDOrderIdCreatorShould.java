package com.adobe.bookstore.infrastructure.services;

import com.adobe.bookstore.domain.OrderIdCreator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class UUIDOrderIdCreatorShould {

    private final OrderIdCreator orderIdCreator = new UUIDOrderIdCreator();

    @Test
    void returnValidUUID() {
        String orderId = orderIdCreator.create();
        assertThat(orderId).isNotNull();
        assertThat(orderId).hasSameSizeAs(UUID.randomUUID().toString());
    }
}