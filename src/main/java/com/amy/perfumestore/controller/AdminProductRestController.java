
package com.amy.perfumestore.controller;

import com.amy.perfumestore.entity.Product;
import com.amy.perfumestore.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/products")
@CrossOrigin(origins = "http://localhost:5173")
public class AdminProductRestController {

    private final ProductRepository productRepository;

    public AdminProductRestController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // ✅ ADMIN: get all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // ✅ ADMIN: update stock
    @PutMapping("/{id}/stock")
    public ResponseEntity<?> updateStock(
            @PathVariable Long id,
            @RequestBody Map<String, Integer> body
    ) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Integer stock = body.get("stock");
        if (stock == null || stock < 0) {
            return ResponseEntity.badRequest().body("Invalid stock value");
        }

        product.setStock(stock);
        productRepository.save(product);

        return ResponseEntity.ok().build();
    }
}
