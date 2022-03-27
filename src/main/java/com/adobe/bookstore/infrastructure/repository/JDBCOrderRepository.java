package com.adobe.bookstore.infrastructure.repository;

import com.adobe.bookstore.domain.Order;
import com.adobe.bookstore.domain.OrderRepository;

import java.util.List;

public class JDBCOrderRepository implements OrderRepository
{


    @Override
    public void save(Order order) {

    }

    @Override
    public List<Order> findAll() {
        return null;
    }
}
