package com.learning.reactive.programming.streaming.controller;

import com.learning.reactive.programming.streaming.dto.ProductDTO;
import com.learning.reactive.programming.streaming.dto.UploadResponse;
import com.learning.reactive.programming.streaming.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductsController {
    private static final Logger logger = LoggerFactory.getLogger(ProductsController.class);

    @Autowired
    private ProductService productService;

    @PostMapping(value = "upload", consumes = MediaType.APPLICATION_NDJSON_VALUE)
    public Mono<UploadResponse> uploadProducts(@RequestBody Flux<ProductDTO> flux) {
        logger.info("Uploading products...");
        return this.productService.saveProducts(flux)
                .then(this.productService.getProductsCount())
                .map(count -> new UploadResponse(UUID.randomUUID(), count));
    }
}
