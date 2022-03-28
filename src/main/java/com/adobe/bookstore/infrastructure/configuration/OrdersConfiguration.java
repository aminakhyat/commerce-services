package com.adobe.bookstore.infrastructure.configuration;

import com.adobe.bookstore.application.getorders.GetOrdersService;
import com.adobe.bookstore.domain.OrderIdCreator;
import com.adobe.bookstore.domain.OrderRepository;
import com.adobe.bookstore.infrastructure.repository.JDBCOrderRepository;
import com.adobe.bookstore.infrastructure.repository.JPAOrderRepository;
import com.adobe.bookstore.infrastructure.services.UUIDOrderIdCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

@Configuration
public class OrdersConfiguration {
    @Bean
    public OrderIdCreator orderIdCreator() {
       return new UUIDOrderIdCreator();
    }

    @Bean
    public OrderRepository orderRepository(){
        return new JPAOrderRepository();
    }

    @Bean
    public GetOrdersService getOrdersService(
            OrderRepository orderRepository
    ){
        return new GetOrdersService(orderRepository);
    }


}
