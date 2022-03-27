package com.adobe.bookstore.application.createorder;

public class CreateOrderResponse {

    private final String id;

    public CreateOrderResponse(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
