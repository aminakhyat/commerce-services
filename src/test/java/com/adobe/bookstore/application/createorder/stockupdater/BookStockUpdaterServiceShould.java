package com.adobe.bookstore.application.createorder.stockupdater;

import com.adobe.bookstore.BookStockRepository;
import com.adobe.bookstore.application.createorder.BookRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BookStockUpdaterServiceShould {

    @Mock
    private BookStockRepository bookStockRepository;

    @InjectMocks
    private BookStockUpdaterService service;

    @Test
    void callUpdateStockForEachBook() {
        doNothing().when(bookStockRepository).updateQuantityByBookId(anyString(), anyInt());
        List<BookRequest> books = List.of(
                new BookRequest("book1", 1),
                new BookRequest("book2", 2),
                new BookRequest("book3", 3)
        );

        service.execute(books);

        verify(bookStockRepository).updateQuantityByBookId("book1", 1);
        verify(bookStockRepository).updateQuantityByBookId("book2", 2);
        verify(bookStockRepository).updateQuantityByBookId("book3", 3);
    }
}