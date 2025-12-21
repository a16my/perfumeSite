package com.amy.perfumestore.controller;

import com.amy.perfumestore.entity.Product;
import com.amy.perfumestore.repository.OrderRepository;
import com.amy.perfumestore.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public AdminController(
            ProductRepository productRepository,
            OrderRepository orderRepository
    ) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    // ✅ LIST PRODUCTS
    @GetMapping("/products")
    public String products(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "admin/products";
    }

    // ✅ SHOW EDIT FORM
    @GetMapping("/products/edit/{id}")
    public String editProduct(@PathVariable Long id, Model model) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        model.addAttribute("product", product);
        return "admin/edit-product";
    }

    // ✅ DELETE PRODUCT (only if NOT used in orders)
    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id, Model model) {

        long usageCount = orderRepository.countProductUsage(id);

        if (usageCount > 0) {
            model.addAttribute("error",
                    "Cannot delete product. It is used in existing orders.");
            model.addAttribute("products", productRepository.findAll());
            return "admin/products";
        }

        productRepository.deleteById(id);
        return "redirect:/admin/products";
    }
}