package com.adobe.bookstore.infrastructure.repository;

import java.io.Serializable;
import java.util.Objects;

public class OrderId implements Serializable {

    private String orderId;
    private String bookId;

    public OrderId() {
    }

    public OrderId(String orderId, String bookId) {
        this.orderId = orderId;
        this.bookId = bookId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderId orderId1 = (OrderId) o;
        return Objects.equals(orderId, orderId1.orderId) && Objects.equals(bookId, orderId1.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, bookId);
    }
}
