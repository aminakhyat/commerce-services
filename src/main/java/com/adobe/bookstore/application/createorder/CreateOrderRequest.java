package com.adobe.bookstore.application.createorder;

import java.util.List;

public class CreateOrderRequest {

    private final List<BookRequest> books;

    public List<BookRequest> getBooks() {
        return books;
    }

    public CreateOrderRequest(List<BookRequest> books) {
        this.books = books;
    }
}
