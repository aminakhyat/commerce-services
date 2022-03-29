package com.adobe.bookstore.application.createorder.stockchecker;

import com.adobe.bookstore.BookStock;
import com.adobe.bookstore.BookStockRepository;
import com.adobe.bookstore.application.createorder.BookRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookStockCheckerServiceShould {

    private static final String BOOK_ID = "123";
    private static final int VALID_QUANTITY = 1;
    private static final int MORE_QUANTITY = 5;

    @Mock
    private BookStockRepository bookStockRepository;

    @InjectMocks
    private BookStockCheckerService service;

    @Test
    void shouldReturnEnoughStock() {
        when(bookStockRepository.findById(BOOK_ID)).thenReturn(Optional.of(aBookStock()));
        List<BookRequest> request = List.of(new BookRequest(BOOK_ID, VALID_QUANTITY));

        boolean response = service.check(request);

        assertTrue(response);
    }

    @Test
    void shouldReturnNotEnoughStock() {
        when(bookStockRepository.findById(BOOK_ID)).thenReturn(Optional.of(aBookStock()));
        List<BookRequest> request = List.of(new BookRequest(BOOK_ID, MORE_QUANTITY));

        boolean response = service.check(request);

        assertFalse(response);
    }

    @Test
    void shouldReturnNotEnoughStockForNotPresentBookStore() {
        when(bookStockRepository.findById(BOOK_ID)).thenReturn(Optional.empty());
        List<BookRequest> request = List.of(new BookRequest(BOOK_ID, VALID_QUANTITY));

        boolean response = service.check(request);

        assertFalse(response);
    }

    public BookStock aBookStock() {
        BookStock bookStock = new BookStock();
        bookStock.setId("444");
        bookStock.setName("book_name");
        bookStock.setQuantity(3);
        return bookStock;
    }
}