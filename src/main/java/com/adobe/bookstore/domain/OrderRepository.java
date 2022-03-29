package com.adobe.bookstore.domain;

import java.util.List;

public interface OrderRepository {
    void save(Order order);
    List<Order> findAll();
}
