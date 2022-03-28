package com.adobe.bookstore.infrastructure.controller.getorders;

import com.adobe.bookstore.application.getorders.GetOrdersService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetOrdersController {

    private final GetOrdersService getOrdersService;

    public GetOrdersController(GetOrdersService getOrdersService) {
        this.getOrdersService = getOrdersService;
    }

    @GetMapping("/orders")
    @ResponseStatus(HttpStatus.OK)
    public GetOrdersControllerResponse getOrders(){
       return GetOrdersControllerResponse.mapFrom(getOrdersService.execute());
    }
}
