package com.adobe.bookstore.application.getorders;

import com.adobe.bookstore.domain.Order;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GetOrdersResponse {

    private final List<OrderResponse> orders;

    public GetOrdersResponse(List<OrderResponse> orders) {
        this.orders = orders;
    }

    public List<OrderResponse> getOrders() {
        return orders;
    }

    public static GetOrdersResponse mapFrom(List<Order> orders) {
        return new GetOrdersResponse(
                orders.stream()
                        .map(o -> new OrderResponse(
                                        o.getId(),
                                        o.getBooks().stream()
                                                .map(b -> new BookResponse(b.getBookId(), b.getQuantity()))
                                                .collect(Collectors.toList())
                                )
                        )
                        .collect(Collectors.toList())
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetOrdersResponse that = (GetOrdersResponse) o;
        return orders.equals(that.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orders);
    }
}
