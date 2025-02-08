package com.example.persistencia_validacao.controller;

import com.example.persistencia_validacao.controller.dto.ProductCreationDto;
import com.example.persistencia_validacao.entity.Product;
import com.example.persistencia_validacao.service.ProductService;
import com.example.persistencia_validacao.service.exception.ProductNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping
  public ResponseEntity<List<Product>> findAll() {
    return ResponseEntity.status(HttpStatus.OK)
        .body(productService.findAll());
  }

  @PostMapping
  public ResponseEntity<Product> create(@RequestBody ProductCreationDto productCreationDto) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(productService.create(productCreationDto.toEntity()));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Product> findByID(@PathVariable Long id) throws ProductNotFound {
    return ResponseEntity.status(HttpStatus.OK)
        .body(productService.findById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Product> update(
      @PathVariable Long id,
      @RequestBody ProductCreationDto productCreationDto
  ) throws ProductNotFound {
    return ResponseEntity.status(HttpStatus.OK)
        .body(productService.update(productCreationDto.toEntity(), id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Product> delete(@PathVariable Long id) throws ProductNotFound {
    return ResponseEntity.status(HttpStatus.OK)
        .body(productService.delete(id));
  }
}
