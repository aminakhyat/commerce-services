package com.adobe.bookstore.infrastructure.controller.getorders;

import java.util.Map;

public class HttpOrderResponse {

    private final String id;
    private final Map<String, Integer> books;

    public HttpOrderResponse(String id, Map<String, Integer> books) {
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
