package com.adobe.bookstore.infrastructure.controller.createorder;

public class HttpBookRequest {

    private String bookId;
    private int quantity;

    public HttpBookRequest() {
    }

    public HttpBookRequest(String bookId, int quantity) {
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
