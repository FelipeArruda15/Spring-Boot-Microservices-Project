package com.felipearruda.stockservice.controller;

import com.felipearruda.stockservice.dto.response.StockResponse;
import com.felipearruda.stockservice.model.Stock;
import com.felipearruda.stockservice.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @GetMapping
    public List<StockResponse> isInStock(@RequestParam List<String> skuCodes) {
        return stockService.isInStock(skuCodes);
    }

}
