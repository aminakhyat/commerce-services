package com.adobe.bookstore.application.getorders;

import com.adobe.bookstore.domain.BookOrder;
import com.adobe.bookstore.domain.Order;
import com.adobe.bookstore.domain.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetOrdersServiceShould {

    private static final String ORDER_ID = "o1";
    private static final String BOOK_ID = "b1";
    private static final int BOOK_QUANTITY = 1;

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private GetOrdersService service;

    @Test
    void returnAllOrders() {
        when(orderRepository.findAll()).thenReturn(
                List.of(new Order(ORDER_ID, List.of(new BookOrder(BOOK_ID, BOOK_QUANTITY))))
        );

        GetOrdersResponse response = service.execute();

        assertThat(response.getOrders()).hasSize(1);
        OrderResponse orderResponse = response.getOrders().get(0);
        assertThat(orderResponse.getId()).isEqualTo(ORDER_ID);
        assertThat(orderResponse.getBooks()).hasSize(1);
        BookResponse bookResponse = orderResponse.getBooks().get(0);
        assertThat(bookResponse.getBookId()).isEqualTo(BOOK_ID);
        assertThat(bookResponse.getQuantity()).isEqualTo(BOOK_QUANTITY);
    }
}