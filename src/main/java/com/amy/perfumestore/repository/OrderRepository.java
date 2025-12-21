
package com.amy.perfumestore.repository;

import com.amy.perfumestore.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    // ✅ USER: view own orders
    @Query("""
        SELECT o FROM Order o
        WHERE o.user.username = :username
    """)
    List<Order> findOrdersByUsername(@Param("username") String username);

    // ✅ ADMIN: check if product is used in any order
    @Query("""
        SELECT COUNT(oi) FROM OrderItem oi
        WHERE oi.product.id = :productId
    """)
    long countProductUsage(@Param("productId") Long productId);
}