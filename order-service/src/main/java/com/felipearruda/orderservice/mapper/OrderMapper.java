package com.felipearruda.orderservice.mapper;

import com.felipearruda.orderservice.dto.request.OrderRequest;
import com.felipearruda.orderservice.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderMapper implements Function<OrderRequest, Order> {

    private final OrderItemMapper orderItemMapper;

    @Override
    public Order apply(OrderRequest orderRequest) {
        return Order.builder()
                .orderItems(orderRequest.getOrderItems().stream().map(orderItemMapper::apply).collect(Collectors.toList()))
                .build();
    }
}
