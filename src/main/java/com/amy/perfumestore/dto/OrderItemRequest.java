package com.amy.perfumestore.dto;

public record OrderItemRequest(
        Long productId,
        int quantity
) {}