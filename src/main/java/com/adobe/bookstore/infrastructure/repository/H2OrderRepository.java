package com.adobe.bookstore.infrastructure.repository;

import com.adobe.bookstore.domain.Order;
import com.adobe.bookstore.domain.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class H2OrderRepository implements OrderRepository {

    private JPAOrderRepository jpaOrderRepository;

    public H2OrderRepository(JPAOrderRepository jpaOrderRepository) {
        this.jpaOrderRepository = jpaOrderRepository;
    }

    @Override
    public void save(Order order) {
        List<OrderJpa> list = new ArrayList<>();
        Map<String, Integer> books = order.getBooks();
        for (var entry : books.entrySet()) {
          list.add(new OrderJpa(order.getId(), entry.getKey(), entry.getValue()));
        }
        jpaOrderRepository.saveAll(list);
    }

    @Override
    public List<Order> findAll() {
       List<OrderJpa>list = jpaOrderRepository.findAll();
       List<Order> orders = new ArrayList<>();
       //TODO
       return orders;
    }
}
