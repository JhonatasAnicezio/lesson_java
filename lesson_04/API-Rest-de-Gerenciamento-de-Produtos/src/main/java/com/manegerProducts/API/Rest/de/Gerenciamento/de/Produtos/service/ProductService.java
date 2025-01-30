package com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.service;

import com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.entity.Product;
import com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.repository.ProductRepository;
import com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.service.exception.ProductNotFoundException;
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

  public Product findById(Long id) throws ProductNotFoundException {
    return productRepository.findById(id)
        .orElseThrow(ProductNotFoundException::new);
  }

  public List<Product> findByAll() {
    return productRepository.findAll();
  }

  public Product create(Product product) {
    return productRepository.save(product);
  }

  public Product update(Long id, Product product) throws ProductNotFoundException {
    Product productInDb = findById(id);

    productInDb.setName(product.getName());
    productInDb.setPrice(product.getPrice());

    return productRepository.save(productInDb);
  }

  public Product delete(Long id) throws ProductNotFoundException {
    Product productInDb = findById(id);

    productRepository.deleteById(id);

    return productInDb;
  }
}
