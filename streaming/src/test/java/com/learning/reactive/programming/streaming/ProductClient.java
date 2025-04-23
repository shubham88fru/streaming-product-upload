package com.learning.reactive.programming.streaming;


import com.learning.reactive.programming.streaming.dto.ProductDTO;
import com.learning.reactive.programming.streaming.dto.UploadResponse;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ProductClient {
    private final WebClient webClient = WebClient.builder()
            .baseUrl("http://localhost:8080")
                .build();


    public Mono<UploadResponse> uploadProducts(Flux<ProductDTO> flux) {
        return this.webClient.post()
                .uri("/products/upload")
                .contentType(MediaType.APPLICATION_NDJSON)
                .body(flux, ProductDTO.class)
                .retrieve()
                .bodyToMono(UploadResponse.class);
    }
}
