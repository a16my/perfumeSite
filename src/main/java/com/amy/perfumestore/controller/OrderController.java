package com.amy.perfumestore.controller;

import com.amy.perfumestore.entity.Order;
import com.amy.perfumestore.service.OrderService;
import com.amy.perfumestore.dto.CreateOrderRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:5173")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // ✅ CREATE ORDER
    @PostMapping
    public Order createOrder(@RequestBody CreateOrderRequest request) {
        return orderService.createOrder(
                request.username(),
                request.items()
        );
    }

    // ✅ USER: get own orders
    @GetMapping("/user/{username}")
    public List<Order> getUserOrders(@PathVariable String username) {
        return orderService.getOrdersForUser(username);
    }
}