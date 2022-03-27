package com.adobe.bookstore.application.createorder;

import java.util.Map;

public class CreateOrderRequest {

    private final Map<String, Integer> books;

    public Map<String, Integer> getBooks() {
        return books;
    }

    public CreateOrderRequest(Map<String, Integer> books) {
        this.books = books;
    }
}
