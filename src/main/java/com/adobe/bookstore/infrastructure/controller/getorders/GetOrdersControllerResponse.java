package com.adobe.bookstore.infrastructure.controller.getorders;

import com.adobe.bookstore.application.getorders.GetOrdersResponse;

import java.util.List;
import java.util.stream.Collectors;

public class GetOrdersControllerResponse {

    private final List<HttpOrderResponse> orders;

    public GetOrdersControllerResponse(List<HttpOrderResponse> orders) {
        this.orders = orders;
    }

    public List<HttpOrderResponse> getOrders() {
        return orders;
    }

    public static GetOrdersControllerResponse mapFrom(GetOrdersResponse getOrdersResponse) {
        return new GetOrdersControllerResponse(getOrdersResponse.getOrders().stream()
                .map(o -> new HttpOrderResponse(o.getId(), o.getBooks()))
                .collect(Collectors.toList()));
    }
}
