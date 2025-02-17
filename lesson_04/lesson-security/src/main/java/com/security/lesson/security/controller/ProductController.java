package com.security.lesson.security.controller;

import com.security.lesson.security.entity.Product;
import com.security.lesson.security.service.ProductsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
  private final ProductsService productsService;

  public ProductController(ProductsService productsService) {
    this.productsService = productsService;
  }

  @GetMapping
  public ResponseEntity<List<Product>> findAll() {
    return ResponseEntity.status(HttpStatus.OK)
        .body(productsService.getProducts());
  }

  @PostMapping
  public ResponseEntity<Product> create(
      @RequestBody Product product
  ) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(productsService.create(product));
  }
}
