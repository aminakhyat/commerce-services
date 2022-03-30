package com.adobe.bookstore.infrastructure.controller.getorders;

import java.util.List;
import java.util.Objects;

public class HttpOrderResponse {

    private final String id;
    private final List<HttpBookResponse> books;

    public HttpOrderResponse(String id, List<HttpBookResponse> books) {
        this.id = id;
        this.books = books;
    }

    public String getId() {
        return id;
    }

    public List<HttpBookResponse> getBooks() {
        return books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HttpOrderResponse that = (HttpOrderResponse) o;
        return id.equals(that.id) && books.equals(that.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, books);
    }
}
