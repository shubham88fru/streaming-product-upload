package com.learning.reactive.programming.streaming.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDTO {
    private Integer id;
    private String description;
    private int price;
}
