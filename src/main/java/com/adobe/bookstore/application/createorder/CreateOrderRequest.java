package com.adobe.bookstore.application.createorder;

import java.util.List;
import java.util.Objects;

public class CreateOrderRequest {

    private final List<BookRequest> books;

    public CreateOrderRequest(List<BookRequest> books) {
        this.books = books;
    }

    public List<BookRequest> getBooks() {
        return books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateOrderRequest that = (CreateOrderRequest) o;
        return Objects.equals(books, that.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(books);
    }
}
