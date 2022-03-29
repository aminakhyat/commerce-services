package com.adobe.bookstore.application.getorders;

public class BookResponse {
    private String bookId;
    private int quantity;

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
}
