package com.adobe.bookstore.domain;

import java.util.Map;

public class Order {

    private final String id;
    private final Map<String, Integer> books;

    public Order(String id, Map<String, Integer> books) {
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
