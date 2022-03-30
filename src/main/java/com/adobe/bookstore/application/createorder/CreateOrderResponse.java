package com.adobe.bookstore.application.createorder;

import java.util.Objects;

public class CreateOrderResponse {

    private final String id;

    public CreateOrderResponse(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateOrderResponse that = (CreateOrderResponse) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
