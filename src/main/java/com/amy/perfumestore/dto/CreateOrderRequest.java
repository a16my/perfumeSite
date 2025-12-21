package com.amy.perfumestore.dto;

import java.util.List;

public record CreateOrderRequest(
        String username,
        List<OrderItemRequest> items
) {}