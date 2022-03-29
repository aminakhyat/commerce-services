package com.adobe.bookstore;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface BookStockRepository extends JpaRepository<BookStock, String> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE book_stock SET quantity=quantity-:quant WHERE id= :bookId", nativeQuery = true)
    void updateQuantityByBookId(@Param("bookId") String bookId, @Param("quant") int quantity);
}
