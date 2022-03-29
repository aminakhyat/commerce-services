package com.adobe.bookstore.infrastructure.configuration;

import com.adobe.bookstore.BookStockRepository;
import com.adobe.bookstore.application.createorder.CreateOrderService;
import com.adobe.bookstore.application.createorder.stockchecker.BookStockCheckerService;
import com.adobe.bookstore.application.createorder.stockupdater.BookStockUpdaterService;
import com.adobe.bookstore.application.getorders.GetOrdersService;
import com.adobe.bookstore.domain.OrderIdCreator;
import com.adobe.bookstore.domain.OrderRepository;
import com.adobe.bookstore.infrastructure.repository.H2OrderRepository;
import com.adobe.bookstore.infrastructure.repository.JPAOrderRepository;
import com.adobe.bookstore.infrastructure.services.UUIDOrderIdCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrdersConfiguration {
    @Bean
    public OrderIdCreator orderIdCreator() {
        return new UUIDOrderIdCreator();
    }

    @Bean
    public OrderRepository orderRepository(JPAOrderRepository jPAOrderRepository) {
        return new H2OrderRepository(jPAOrderRepository);
    }

    @Bean
    public GetOrdersService getOrdersService(OrderRepository orderRepository) {
        return new GetOrdersService(orderRepository);
    }

    @Bean
    public BookStockUpdaterService bookStockUpdaterService(BookStockRepository bookStockRepository) {
        return new BookStockUpdaterService(bookStockRepository);
    }

    @Bean
    public BookStockCheckerService bookStockCheckerService(BookStockRepository bookStockRepository) {
        return new BookStockCheckerService(bookStockRepository);
    }

    @Bean
    public CreateOrderService createOrderService(BookStockCheckerService checker,
                                                 OrderRepository orderRepository,
                                                 OrderIdCreator orderIdCreator,
                                                 BookStockUpdaterService bookStockUpdaterService) {
        return new CreateOrderService(checker, orderRepository, orderIdCreator, bookStockUpdaterService);
    }
}
