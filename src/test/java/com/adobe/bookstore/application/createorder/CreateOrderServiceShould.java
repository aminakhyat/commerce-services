package com.adobe.bookstore.application.createorder;

import com.adobe.bookstore.application.createorder.stockchecker.BookStockCheckerService;
import com.adobe.bookstore.application.createorder.stockupdater.BookStockUpdaterService;
import com.adobe.bookstore.domain.OrderIdCreator;
import com.adobe.bookstore.domain.OrderRepository;
import com.adobe.bookstore.domain.exception.NotEnoughStockException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateOrderServiceShould {

    public static final String ORDER_ID = "o1";
    private static final String BOOK_ID_1 = "b1";
    private static final String BOOK_ID_2 = "b2";
    private static final int QUANTITY_BOOK_1 = 1;
    private static final int QUANTITY_BOOK_2 = 2;

    @Mock
    private BookStockCheckerService checker;
    @Mock
    private OrderRepository orderRepository;
    @Mock
    private OrderIdCreator orderIdCreator;
    @Mock
    private BookStockUpdaterService bookStockUpdaterService;
    @InjectMocks
    private CreateOrderService service;

    @Test
    void returnNotEnoughStockIfThereIsNotEnough() {
        when(checker.check(aBooksRequest())).thenReturn(false);

        assertThatThrownBy(() -> service.execute(aCreateOrderRequest()))
                .isInstanceOf(NotEnoughStockException.class);
    }

    @Test
    void returnOrderIdForValidOne() {
        when(checker.check(aBooksRequest())).thenReturn(true);
        when(orderIdCreator.create()).thenReturn(ORDER_ID);
        doNothing().when(orderRepository).save(any());
        doNothing().when(bookStockUpdaterService).execute(aBooksRequest());

        CreateOrderResponse response = service.execute(aCreateOrderRequest());

        assertThat(response.getId()).isEqualTo(ORDER_ID);
        verify(orderRepository).save(any());
        verify(bookStockUpdaterService).execute(aBooksRequest());
    }

    private CreateOrderRequest aCreateOrderRequest() {
        return new CreateOrderRequest(aBooksRequest());
    }

    private List<BookRequest> aBooksRequest() {
        return List.of(
                new BookRequest(BOOK_ID_1, QUANTITY_BOOK_1),
                new BookRequest(BOOK_ID_2, QUANTITY_BOOK_2)
        );
    }
}