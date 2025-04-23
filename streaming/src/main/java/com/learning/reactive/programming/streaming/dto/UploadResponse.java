package com.learning.reactive.programming.streaming.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class UploadResponse {
    private UUID confirmationId;
    private Long productsCount;
}
