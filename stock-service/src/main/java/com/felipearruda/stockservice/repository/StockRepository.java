package com.felipearruda.stockservice.repository;

import com.felipearruda.stockservice.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    Boolean existsByskuCode(String skuCode);

    List<Stock> findByskuCodeIn(List<String> skuCode);

}
