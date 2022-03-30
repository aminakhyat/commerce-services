package com.adobe.bookstore.application.getorders;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderResponse that = (OrderResponse) o;
        return id.equals(that.id) && books.equals(that.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, books);
    }
}
