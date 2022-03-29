package com.adobe.bookstore.infrastructure.controller.createorder;

import com.adobe.bookstore.domain.exception.NotEnoughStockException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CreateOrderControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NotEnoughStockException.class)
    public ResponseEntity<Object> handleCityNotFoundException(
            NotEnoughStockException ex, WebRequest request) {
        return new ResponseEntity<>("Not enough stock", HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
