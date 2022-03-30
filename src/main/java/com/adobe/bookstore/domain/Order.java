package com.adobe.bookstore.domain;

import java.util.List;
import java.util.Objects;

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

    public List<BookOrder> getBooks() {
        return books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id.equals(order.id) && books.equals(order.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, books);
    }
}
