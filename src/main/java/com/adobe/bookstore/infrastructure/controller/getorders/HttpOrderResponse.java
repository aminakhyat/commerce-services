package com.adobe.bookstore.infrastructure.controller.getorders;

import java.util.List;

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

    public List<HttpBookResponse>getBooks() {
        return books;
    }
}
