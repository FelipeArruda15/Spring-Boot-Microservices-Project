package com.felipearruda.stockservice.controller;

import com.felipearruda.stockservice.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stock")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @GetMapping("/{sku-code}")
    public boolean isInStock(@PathVariable("sku-code") String skuCode) {
        return stockService.isInStock(skuCode);
    }

}
