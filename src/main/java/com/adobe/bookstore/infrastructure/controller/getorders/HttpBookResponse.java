package com.adobe.bookstore.infrastructure.controller.getorders;

public class HttpBookResponse {

    private final String bookId;
    private final int quantity;

    public HttpBookResponse(String bookId, int quantity) {
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
