package com.adobe.bookstore.infrastructure.services;

import com.adobe.bookstore.domain.OrderIdCreator;

import java.util.UUID;

public class UUIDOrderIdCreator implements OrderIdCreator {

    @Override
    public String create() {
        return UUID.randomUUID().toString();
    }
}
