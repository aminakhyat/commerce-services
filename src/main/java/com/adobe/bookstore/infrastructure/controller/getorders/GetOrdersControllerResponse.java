package com.adobe.bookstore.infrastructure.controller.getorders;

import com.adobe.bookstore.application.getorders.GetOrdersResponse;

import java.util.List;
import java.util.Objects;
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
                .map(o -> new HttpOrderResponse(
                        o.getId(),
                        o.getBooks()
                                .stream()
                                .map(b -> new HttpBookResponse(b.getBookId(), b.getQuantity()))
                                .collect(Collectors.toList()))
                )
                .collect(Collectors.toList()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetOrdersControllerResponse that = (GetOrdersControllerResponse) o;
        return orders.equals(that.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orders);
    }
}
