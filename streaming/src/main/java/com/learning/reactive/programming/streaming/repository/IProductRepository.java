package com.learning.reactive.programming.streaming.repository;

import com.learning.reactive.programming.streaming.entity.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends ReactiveCrudRepository<Product, Integer> {
}
