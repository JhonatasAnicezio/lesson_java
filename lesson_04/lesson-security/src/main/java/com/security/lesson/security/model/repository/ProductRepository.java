package com.security.lesson.security.model.repository;

import com.security.lesson.security.model.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Long> {
}
