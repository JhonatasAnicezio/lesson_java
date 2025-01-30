package com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.controller;

import com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.entity.Product;
import com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.service.ProductService;
import com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.service.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<Product> findById(@PathVariable Long id) throws ProductNotFoundException {
    return ResponseEntity.status(HttpStatus.OK)
        .body(productService.findById(id));
  }

  @GetMapping
  public ResponseEntity<List<Product>> findAll() {
    return ResponseEntity.status(HttpStatus.OK)
        .body(productService.findByAll());
  }

  @PostMapping
  public ResponseEntity<Product> create(@RequestBody Product product) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(productService.create(product));
  }

  @PutMapping
  public ResponseEntity<Product> update(
      @PathVariable Long id,
      @RequestBody Product product
  ) throws ProductNotFoundException {
    return ResponseEntity.status(HttpStatus.OK)
        .body(productService.update(id, product));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Product> delete(@PathVariable Long id) throws ProductNotFoundException {
    return ResponseEntity.status(HttpStatus.OK)
        .body(productService.delete(id));
  }
}
