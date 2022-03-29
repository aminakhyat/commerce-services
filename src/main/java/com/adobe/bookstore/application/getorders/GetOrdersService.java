package com.adobe.bookstore.application.getorders;

import com.adobe.bookstore.domain.OrderRepository;

import java.util.stream.Collectors;

public class GetOrdersService {
    private final OrderRepository orderRepository;

    public GetOrdersService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public GetOrdersResponse execute() {
        return new GetOrdersResponse(
                this.orderRepository.findAll()
                        .stream()
                        .map(o -> new OrderResponse(
                                o.getId(),
                                o.getBooks().stream()
                                        .map(b-> new BookResponse(b.getBookId(), b.getQuantity()))
                                        .collect(Collectors.toList())
                                )
                        )
                        .collect(Collectors.toList())
        );
    }
}
