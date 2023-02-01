package com.felipearruda.productservice.service;

import com.felipearruda.productservice.dto.request.ProductRequest;
import com.felipearruda.productservice.dto.response.ProductResponse;
import com.felipearruda.productservice.mapper.ProductMapper;
import com.felipearruda.productservice.mapper.ProductResponseMapper;
import com.felipearruda.productservice.model.Product;
import com.felipearruda.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductResponseMapper productResponseMapper;

    public void createProduct(ProductRequest productRequest) {
         Product product = productRepository.save(productMapper.apply(productRequest));

         log.info("Produto {} foi salvo", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productResponseMapper::apply)
                .collect(Collectors.toList());
    }

}
