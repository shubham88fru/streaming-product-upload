package com.learning.reactive.programming.streaming;

import com.learning.reactive.programming.streaming.dto.ProductDTO;
import com.learning.reactive.programming.streaming.entity.Product;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;

public class ProductsUploadDownloadTest {
    private static final Logger logger = LoggerFactory.getLogger(ProductsUploadDownloadTest.class);
    private final ProductClient productClient = new ProductClient();

    @Test
    public void upload() {
        Flux<ProductDTO> flux1 = Flux.just(new ProductDTO(null, "iphone", 1000))
                .delayElements(Duration.ofSeconds(10));

        Flux<ProductDTO> flux2 = Flux.range(1, 10)
                .map(i -> new ProductDTO(null, "iphone", i))
                .delayElements(Duration.ofSeconds(2));

        Flux<ProductDTO> flux3 = Flux.range(1, 1_000_000)
                .map(i -> new ProductDTO(null, "iphone-" + i, i));


        this.productClient.uploadProducts(flux3)
                .doOnNext(r -> logger.info("Received: {}", r))
                .then()
                .as(StepVerifier::create)
                .expectComplete()
                .verify();
    }
}
