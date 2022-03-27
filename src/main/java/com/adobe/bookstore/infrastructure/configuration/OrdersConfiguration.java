package com.adobe.bookstore.infrastructure.configuration;

import com.adobe.bookstore.domain.OrderIdCreator;
import com.adobe.bookstore.domain.OrderRepository;
import com.adobe.bookstore.infrastructure.repository.JDBCOrderRepository;
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
    public OrderRepository orderRepository(){
        return new JDBCOrderRepository();
    }


}
