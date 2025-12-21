package com.amy.perfumestore.dto;

import com.amy.perfumestore.entity.OrderStatus;

public record UpdateOrderStatusRequest(OrderStatus status) {}