package com.adobe.bookstore.infrastructure.controller.createorder;

import com.adobe.bookstore.application.createorder.BookRequest;
import com.adobe.bookstore.application.createorder.CreateOrderRequest;
import com.adobe.bookstore.application.createorder.CreateOrderResponse;
import com.adobe.bookstore.application.createorder.CreateOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CreateOrderController {

    private final CreateOrderService createOrderService;

    public CreateOrderController(CreateOrderService createOrderService) {
        this.createOrderService = createOrderService;
    }

    @PostMapping("/order")
    @ResponseStatus(HttpStatus.CREATED)
    public String createOrder(@RequestBody List<HttpBookRequest> request) {
        CreateOrderResponse response = createOrderService.execute(
                new CreateOrderRequest(
                        request.stream()
                                .map(b -> new BookRequest(b.getBookId(), b.getQuantity()))
                                .collect(Collectors.toList())
                )
        );
        return response.getId();
    }
}
