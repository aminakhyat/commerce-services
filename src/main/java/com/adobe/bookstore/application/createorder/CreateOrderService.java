package com.adobe.bookstore.application.createorder;

import com.adobe.bookstore.application.createorder.stockchecker.BookStockCheckerService;
import com.adobe.bookstore.application.createorder.stockupdater.BookStockUpdaterService;
import com.adobe.bookstore.domain.BookOrder;
import com.adobe.bookstore.domain.Order;
import com.adobe.bookstore.domain.OrderIdCreator;
import com.adobe.bookstore.domain.OrderRepository;
import com.adobe.bookstore.domain.exception.NotEnoughStockException;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class CreateOrderService {

    private final BookStockCheckerService checker;
    private final OrderRepository orderRepository;
    private final OrderIdCreator orderIdCreator;
    private final BookStockUpdaterService bookStockUpdaterService;

    public CreateOrderService(BookStockCheckerService checker,
                              OrderRepository orderRepository,
                              OrderIdCreator orderIdCreator,
                              BookStockUpdaterService bookStockUpdaterService) {
        this.checker = checker;
        this.orderRepository = orderRepository;
        this.orderIdCreator = orderIdCreator;
        this.bookStockUpdaterService = bookStockUpdaterService;
    }

    public CreateOrderResponse execute(CreateOrderRequest request) {
        if (!checker.check(request.getBooks())) {
            throw new NotEnoughStockException();
        }

        String orderId = orderIdCreator.create();

        Order order = new Order(orderId, request.getBooks().stream()
                .map(b -> new BookOrder(b.getBookId(), b.getQuantity()))
                .collect(Collectors.toList()));
        orderRepository.save(order);

       CompletableFuture.runAsync(() -> bookStockUpdaterService.execute(request.getBooks()));

       return new CreateOrderResponse(orderId);
    }
}
