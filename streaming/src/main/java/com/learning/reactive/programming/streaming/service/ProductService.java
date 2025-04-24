package com.learning.reactive.programming.streaming.service;

import com.learning.reactive.programming.streaming.dto.ProductDTO;
import com.learning.reactive.programming.streaming.mapper.EntityDtoMapper;
import com.learning.reactive.programming.streaming.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    @Autowired
    private IProductRepository productRepository;

    public Flux<ProductDTO> saveProducts(Flux<ProductDTO> flux) {
        return this.productRepository
                .saveAll(flux.map(EntityDtoMapper::toEntity))
                .map(EntityDtoMapper::toDto);
    }

    public Mono<Long> getProductsCount() {
        return this.productRepository.count();
    }

    public Flux<ProductDTO> allProducts() {
        return this.productRepository.findAll()
                .map(EntityDtoMapper::toDto);
    }
}

