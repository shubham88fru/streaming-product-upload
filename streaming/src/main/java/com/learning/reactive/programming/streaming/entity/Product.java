package com.learning.reactive.programming.streaming.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Product {

    @Id
    private Integer id;
    private String description;
    private int price;
}
