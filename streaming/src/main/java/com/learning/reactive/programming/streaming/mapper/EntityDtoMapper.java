package com.learning.reactive.programming.streaming.mapper;

import com.learning.reactive.programming.streaming.dto.ProductDTO;
import com.learning.reactive.programming.streaming.entity.Product;

public class EntityDtoMapper {

    public static Product toEntity(ProductDTO dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        return product;
    }

    public static ProductDTO toDto(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getDescription(),
                product.getPrice()
        );
    }
}
