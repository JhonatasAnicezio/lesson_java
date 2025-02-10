package com.example.persistencia_validacao.service;

import com.example.persistencia_validacao.entity.Product;
import com.example.persistencia_validacao.repository.ProductRepository;
import com.example.persistencia_validacao.service.exception.ProductNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProductService {
  private final ProductRepository productRepository;

  @Autowired
  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<Product> findAll() {
    return productRepository.findAll();
  }

  public Product create(Product product) {
    return productRepository.save(product);
  }

  public Product findById(Long id) throws ProductNotFound {
    return productRepository.findById(id)
        .orElseThrow(ProductNotFound::new);
  }

  public Product update(Product product, Long id) throws ProductNotFound {
    Product productInDb = findById(id);
    productInDb.setName(product.getName());
    productInDb.setExpirationDate(product.getExpirationDate());
    productInDb.setManufactureDate(product.getManufactureDate());

    return productRepository.save(productInDb);
  }

  public Product delete(Long id) throws ProductNotFound {
    Product product = findById(id);

    productRepository.deleteById(id);

    return product;
  }

  public List<Product> findExpiredProducts() {
    return productRepository.findAll().stream()
        .filter(product -> product.getExpirationDate().isBefore(LocalDate.now()))
        .toList();
  }

  public List<Product> findNonExpiredProducts() {
    return productRepository.findAll().stream()
        .filter(product -> product.getExpirationDate().isAfter(LocalDate.now()))
        .toList();
  }

  public List<Product> findExpiresAtProducts(LocalDate start, LocalDate end) {
    return productRepository.findAll().stream()
        .filter(product -> product.getExpirationDate().isAfter(start.minusDays(1))
                && product.getExpirationDate().isBefore(end.plusDays(1)))
        .toList();
  }
}
