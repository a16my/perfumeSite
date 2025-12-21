
package com.amy.perfumestore.repository;

//import com.amy.perfumestore.entity.Category;
import com.amy.perfumestore.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}