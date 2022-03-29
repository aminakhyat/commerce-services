package com.adobe.bookstore.application.createorder.stockchecker;

import com.adobe.bookstore.BookStock;
import com.adobe.bookstore.BookStockRepository;
import com.adobe.bookstore.application.createorder.BookRequest;

import java.util.List;
import java.util.Optional;

public class BookStockCheckerService {

    private final BookStockRepository bookStockRepository;

    public BookStockCheckerService(BookStockRepository bookStockRepository) {
        this.bookStockRepository = bookStockRepository;
    }

    public boolean check(List<BookRequest> books) {
        for (BookRequest book : books) {
            Optional<BookStock> bookStockOptional = bookStockRepository.findById(book.getBookId());
            if (bookStockOptional.isPresent()) {
                BookStock bookStock = bookStockOptional.get();
                if (bookStock.getQuantity() < book.getQuantity()) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
