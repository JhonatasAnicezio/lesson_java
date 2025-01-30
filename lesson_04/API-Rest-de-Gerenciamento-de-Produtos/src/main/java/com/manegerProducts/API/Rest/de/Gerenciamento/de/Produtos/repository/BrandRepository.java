package com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.repository;

import com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
}
