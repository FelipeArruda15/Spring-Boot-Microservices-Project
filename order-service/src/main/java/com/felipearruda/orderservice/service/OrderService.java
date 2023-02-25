package com.felipearruda.orderservice.service;

import com.felipearruda.orderservice.dto.request.OrderRequest;
import com.felipearruda.orderservice.dto.response.StockResponse;
import com.felipearruda.orderservice.mapper.OrderMapper;
import com.felipearruda.orderservice.model.Order;
import com.felipearruda.orderservice.model.OrderItem;
import com.felipearruda.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final WebClient.Builder webClientBuilder;

    @Transactional
    public void placeOrder(OrderRequest orderRequest) {
        Order order = orderMapper.apply(orderRequest);
        order.setOrderNumber(UUID.randomUUID().toString());

        List<String> skuCodes = order.getOrderItems().stream()
                .map(OrderItem::getSkuCode)
                .toList();


        StockResponse[] stock =  webClientBuilder.build().get()
                .uri("http://stock-service/api/stock",
                        uriBuilder -> uriBuilder.queryParam("skuCodes", skuCodes).build())
                .retrieve()
                .bodyToMono(StockResponse[].class)
                .block();

        boolean result = false;

        if (stock != null && stock.length > 0) {
            result = Arrays.stream(stock).allMatch(StockResponse::isInStock);
        }

        if (result) {
            orderRepository.save(order);
            log.info("Pedido feito com sucesso");
        } else {
            throw new IllegalArgumentException("O produto não está em estoque, tente novamente mais tarde");
        }

    }
}
