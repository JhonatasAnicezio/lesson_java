package com.security.lesson.security.service;

import com.security.lesson.security.model.entity.Products;
import com.security.lesson.security.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
  private final ProductRepository productRepository;

  @Autowired
  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Products create(Products products) {
    return productRepository.save(products);
  }

  public List<Products> findAll() {
    return productRepository.findAll();
  }
}
