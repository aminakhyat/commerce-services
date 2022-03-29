package com.adobe.bookstore.application.createorder;

import com.adobe.bookstore.domain.BookOrder;
import com.adobe.bookstore.domain.Order;
import com.adobe.bookstore.domain.OrderIdCreator;
import com.adobe.bookstore.domain.OrderRepository;
import com.adobe.bookstore.domain.exception.NotEnoughStockException;
import com.adobe.bookstore.domain.stockchecker.BookStockCheckerService;

import java.util.stream.Collectors;

public class CreateOrderService {

    private final BookStockCheckerService checker;
    private final OrderRepository orderRepository;
    private final OrderIdCreator orderIdCreator;

    public CreateOrderService(BookStockCheckerService checker,
                              OrderRepository orderRepository,
                              OrderIdCreator orderIdCreator) {
        this.checker = checker;
        this.orderRepository = orderRepository;
        this.orderIdCreator = orderIdCreator;
    }

    public CreateOrderResponse execute(CreateOrderRequest request) {
        if (!checker.check()) {
            throw new NotEnoughStockException("There's not enough stock");
        }

        String orderId = orderIdCreator.create();

        Order order = new Order(orderId, request.getBooks().stream()
                .map(b -> new BookOrder(b.getBookId(), b.getQuantity()))
                .collect(Collectors.toList()));
        orderRepository.save(order);

        return new CreateOrderResponse(orderId);
    }
}
