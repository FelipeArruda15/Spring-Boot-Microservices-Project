package com.felipearruda.productservice.mapper;

import com.felipearruda.productservice.dto.request.ProductRequest;
import com.felipearruda.productservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ProductMapper implements Function<ProductRequest, Product> {

    @Override
    public Product apply(ProductRequest productRequest) {
        return Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
    }
}
