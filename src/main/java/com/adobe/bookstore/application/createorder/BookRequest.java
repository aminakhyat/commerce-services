package com.adobe.bookstore.application.createorder;

public class BookRequest {
    private String bookId;
    private int quantity;

    public String getBookId() {
        return bookId;
    }

    public int getQuantity() {
        return quantity;
    }

    public BookRequest(String bookId, int quantity) {
        this.bookId = bookId;
        this.quantity = quantity;
    }
}
