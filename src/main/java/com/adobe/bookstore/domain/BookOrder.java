package com.adobe.bookstore.domain;

public class BookOrder {
    private String bookId;
    private int quantity;

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
}
