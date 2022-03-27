//package com.adobe.bookstore.infrastructure.controller;
//
//import com.adobe.bookstore.application.getorders.GetOrdersService;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class GetOrdersController {
//
//    private final GetOrdersService getOrdersService;
//
//    public GetOrdersController(GetOrdersService getOrdersService) {
//        this.getOrdersService = getOrdersService;
//    }
//
//    @GetMapping("/orders")
//    public void getOrders(){
//        getOrdersService.execute();
//    }
//}
