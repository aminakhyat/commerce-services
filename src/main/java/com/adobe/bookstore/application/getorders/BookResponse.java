package com.adobe.bookstore.application.getorders;

import java.util.Objects;

public class BookResponse {

    private final String bookId;
    private final int quantity;

    public BookResponse(String bookId, int quantity) {
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
        BookResponse that = (BookResponse) o;
        return quantity == that.quantity && bookId.equals(that.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, quantity);
    }
}
