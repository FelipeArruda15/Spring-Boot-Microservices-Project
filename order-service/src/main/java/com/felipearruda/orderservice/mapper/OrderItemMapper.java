package com.felipearruda.orderservice.mapper;

import com.felipearruda.orderservice.dto.request.OrderItemDto;
import com.felipearruda.orderservice.model.OrderItem;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class OrderItemMapper implements Function<OrderItemDto, OrderItem> {

    @Override
    public OrderItem apply(OrderItemDto orderItemDto) {
        return OrderItem.builder()
                .id(orderItemDto.getId())
                .price(orderItemDto.getPrice())
                .quantity(orderItemDto.getQuantity())
                .skuCode(orderItemDto.getSkuCode())
                .build();
    }
}
