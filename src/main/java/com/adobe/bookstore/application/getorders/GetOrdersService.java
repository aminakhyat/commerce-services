package com.adobe.bookstore.application.getorders;

import com.adobe.bookstore.domain.OrderRepository;

public class GetOrdersService {

    private final OrderRepository orderRepository;

    public GetOrdersService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public GetOrdersResponse execute() {
        return GetOrdersResponse.mapFrom(orderRepository.findAll());
    }
}
