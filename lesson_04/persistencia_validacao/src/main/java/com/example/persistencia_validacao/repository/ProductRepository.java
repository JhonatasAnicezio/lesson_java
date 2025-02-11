package com.example.persistencia_validacao.repository;

import com.example.persistencia_validacao.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
  @Query(
      value = "SELECT * FROM products WHERE expirationDate < CURRENT_DATE",
      nativeQuery = true
  )
  List<Product> findExpiredProducts();

  @Query("SELECT p FROM Product p WHERE p.expirationDate >= CURRENT_DATE")
  List<Product> findNonExpiredProducts();

  @Query("SELECT p FROM Product p WHERE p.expirationDate BETWEEN :start AND :end")
  List<Product> findExpiredAtProducts(
      @Param("start") LocalDate start,
      @Param("end") LocalDate end
  );
}
