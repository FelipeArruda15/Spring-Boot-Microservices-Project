package com.felipearruda.stockservice;

import com.felipearruda.stockservice.model.Stock;
import com.felipearruda.stockservice.repository.StockRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StockServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(StockRepository stockRepository) {
		return args -> {
			Stock stock = new Stock();
			stock.setSkuCode("Ar_condicionado");
			stock.setQuantity(20);

			Stock stock1 = new Stock();
			stock1.setSkuCode("Iphone 11 256GB");
			stock1.setQuantity(10);

			stockRepository.save(stock);
			stockRepository.save(stock1);
		};
	}


}
