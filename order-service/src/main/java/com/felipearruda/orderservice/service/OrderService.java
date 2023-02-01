package com.felipearruda.orderservice.service;

import com.felipearruda.orderservice.dto.request.OrderRequest;
import com.felipearruda.orderservice.mapper.OrderMapper;
import com.felipearruda.orderservice.model.Order;
import com.felipearruda.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Transactional
    public void placeOrder(OrderRequest orderRequest) {
        Order order = orderMapper.apply(orderRequest);
        order.setOrderNumber(UUID.randomUUID().toString());
        orderRepository.save(order);
        log.info("Pedido feito com sucesso");
    }
}
