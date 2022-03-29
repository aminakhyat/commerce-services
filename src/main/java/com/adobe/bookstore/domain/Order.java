package com.adobe.bookstore.domain;

import java.util.List;

public class Order {

    private final String id;
    private final List<BookOrder> books;

    public Order(String id, List<BookOrder> books) {
        this.id = id;
        this.books = books;
    }

    public String getId() {
        return id;
    }

    public List<BookOrder>  getBooks() {
        return books;
    }
}
