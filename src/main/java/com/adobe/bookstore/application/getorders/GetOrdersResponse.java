package com.adobe.bookstore.application.getorders;

import java.util.List;

public class GetOrdersResponse {

    private final List<OrderResponse> orders;

    public GetOrdersResponse(List<OrderResponse> orders) {
        this.orders = orders;
    }

    public List<OrderResponse> getOrders() {
        return orders;
    }
}
