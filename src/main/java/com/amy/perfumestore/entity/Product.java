package com.amy.perfumestore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Basic info
    @Column(nullable = false)
    private String name;

    private String brand;

    // Pricing
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    private int stock;

    // Perfume description
    @Column(length = 1000)
    private String description;

    private String smell;      // sweet, woody, spicy, etc.
    private String vibes;      // elegant, dark, fresh, bold
    private String forWho;     // daily, special occasions, office

    private String gender;     // MEN / WOMEN / UNISEX
    private String wearTime;   // DAY / NIGHT / ALL
}