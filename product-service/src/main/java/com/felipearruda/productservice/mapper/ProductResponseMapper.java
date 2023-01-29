package com.felipearruda.productservice.mapper;

import com.felipearruda.productservice.dto.response.ProductResponse;
import com.felipearruda.productservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ProductResponseMapper implements Function<Product, ProductResponse> {

    @Override
    public ProductResponse apply(Product product) {
        return ProductResponse.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
