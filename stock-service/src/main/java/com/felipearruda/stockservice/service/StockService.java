package com.felipearruda.stockservice.service;

import com.felipearruda.stockservice.dto.response.StockResponse;
import com.felipearruda.stockservice.model.Stock;
import com.felipearruda.stockservice.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;

    @Transactional(readOnly = true)
    public List<StockResponse> isInStock(List<String> skuCodes) {
        return  stockRepository.findByskuCodeIn(skuCodes)
                .stream()
                .map(item ->
                    StockResponse.builder()
                            .skuCode(item.getSkuCode())
                            .isInStock(item.getQuantity() > 0)
                            .build()
                ).collect(Collectors.toList());
    }

}
