package com.felipearruda.stockservice.service;

import com.felipearruda.stockservice.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;

    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode) {
        return stockRepository.existsByskuCode(skuCode);
    }

}
