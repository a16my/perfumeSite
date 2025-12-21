package com.amy.perfumestore.controller;

import com.amy.perfumestore.dto.UpdateOrderStatusRequest;
import com.amy.perfumestore.entity.Order;
import com.amy.perfumestore.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/orders")
public class AdminOrderController {

    private final OrderService orderService;

    public AdminOrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // ✅ ADMIN: view all orders
    @GetMapping
    public List<Order> allOrders() {
        return orderService.getAllOrders();
    }

    // ✅ ADMIN: update status
    @PutMapping("/{id}/status")
    public Order updateStatus(
            @PathVariable Long id,
            @RequestBody UpdateOrderStatusRequest request
    ) {
        return orderService.updateStatus(id, request.status());
    }
}