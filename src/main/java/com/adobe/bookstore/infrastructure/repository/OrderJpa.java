package com.adobe.bookstore.infrastructure.repository;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "orders")
@IdClass(OrderId.class)
@JsonSerialize
public class OrderJpa implements Serializable {
    @Id
    @Column(name = "order_id", nullable=false)
    private String orderId;
    @Id
    @Column(name= "book_id", nullable= false)
    private String bookId;
    @Column(nullable = false)
    private int quantity;

    public OrderJpa(String orderId, String bookId, int quantity) {
        this.orderId = orderId;
        this.bookId = bookId;
        this.quantity = quantity;
    }

    public OrderJpa() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
