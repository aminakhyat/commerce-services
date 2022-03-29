package com.adobe.bookstore.application.createorder;

import java.util.Objects;

public class BookRequest {
    private final String bookId;
    private final int quantity;

    public BookRequest(String bookId, int quantity) {
        this.bookId = bookId;
        this.quantity = quantity;
    }

    public String getBookId() {
        return bookId;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookRequest that = (BookRequest) o;
        return quantity == that.quantity && bookId.equals(that.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, quantity);
    }
}
