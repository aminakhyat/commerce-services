package com.adobe.bookstore.domain;

import java.util.Objects;

public class BookOrder {

    private final String bookId;
    private final int quantity;

    public BookOrder(String bookId, int quantity) {
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
        BookOrder bookOrder = (BookOrder) o;
        return quantity == bookOrder.quantity && bookId.equals(bookOrder.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, quantity);
    }
}
