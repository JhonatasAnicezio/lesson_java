package com.security.lesson.security.service;

import com.security.lesson.security.entity.Product;
import com.security.lesson.security.repository.ProductsRepository;
import com.security.lesson.security.service.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
  private final ProductsRepository productsRepository;

  @Autowired
  public ProductsService(ProductsRepository productsRepository) {
    this.productsRepository = productsRepository;
  }

  public List<Product> getProducts() {
    return productsRepository.findAll();
  }

  public Product findById(Long id) throws ProductNotFoundException {
    return productsRepository.findById(id)
        .orElseThrow(ProductNotFoundException::new);
  }

  public Product create(Product product) {
    return productsRepository.save(product);
  }
}
