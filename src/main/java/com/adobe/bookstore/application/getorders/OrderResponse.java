package com.adobe.bookstore.application.getorders;

import java.util.List;

public class OrderResponse {

    private final String id;
    private final List<BookResponse> books;

    public OrderResponse(String id, List<BookResponse> books) {
        this.id = id;
        this.books = books;
    }

    public String getId() {
        return id;
    }

    public List<BookResponse> getBooks() {
        return books;
    }
}
