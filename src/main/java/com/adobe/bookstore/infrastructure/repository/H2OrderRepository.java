package com.adobe.bookstore.infrastructure.repository;

import com.adobe.bookstore.domain.BookOrder;
import com.adobe.bookstore.domain.Order;
import com.adobe.bookstore.domain.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class H2OrderRepository implements OrderRepository {

    private final JPAOrderRepository jpaOrderRepository;

    public H2OrderRepository(JPAOrderRepository jpaOrderRepository) {
        this.jpaOrderRepository = jpaOrderRepository;
    }

    @Override
    public void save(Order order) {
        List<OrderJpa> list = new ArrayList<>();
        List<BookOrder> books = order.getBooks();
        for (var entry : books) {
            list.add(new OrderJpa(order.getId(), entry.getBookId(), entry.getQuantity()));
        }
        jpaOrderRepository.saveAll(list);
    }

    @Override
    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();

        Map<String, List<OrderJpa>> ordersById = jpaOrderRepository.findAll()
                .stream()
                .collect(groupingBy(OrderJpa::getOrderId));

        for (Map.Entry<String, List<OrderJpa>> entry : ordersById.entrySet()) {
            List<BookOrder> books = new ArrayList<>();
            for (OrderJpa o : entry.getValue()) {
                books.add(new BookOrder(o.getBookId(), o.getQuantity()));
            }
            Order newOrder = new Order(entry.getKey(), books);
            orders.add(newOrder);
        }
        return orders;
    }
}
