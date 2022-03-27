package com.adobe.bookstore.application.getorders;

import java.util.Map;

public class OrderResponse {

    private final String id;
    private final Map<String, Integer> books;

    public OrderResponse(String id, Map<String, Integer> books) {
        this.id = id;
        this.books = books;
    }

    public String getId() {
        return id;
    }

    public Map<String, Integer> getBooks() {
        return books;
    }
}
