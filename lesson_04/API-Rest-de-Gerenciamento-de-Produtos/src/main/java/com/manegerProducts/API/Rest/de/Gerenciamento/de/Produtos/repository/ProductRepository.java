package com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.repository;

import com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
