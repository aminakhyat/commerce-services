package com.adobe.bookstore.application.createorder.stockupdater;

import com.adobe.bookstore.BookStockRepository;
import com.adobe.bookstore.application.createorder.BookRequest;

import java.util.List;

public class BookStockUpdaterService {

    private final BookStockRepository bookStockRepository;

    public BookStockUpdaterService(BookStockRepository bookStockRepository) {
        this.bookStockRepository = bookStockRepository;
    }

    public void execute(List<BookRequest> books) {
        for (BookRequest book : books) {
            bookStockRepository.updateQuantityByBookId(book.getBookId(), book.getQuantity());
        }
    }
}
