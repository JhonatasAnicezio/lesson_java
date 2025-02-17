package com.security.lesson.security.controller;

import com.security.lesson.security.controller.dto.ProductDto;
import com.security.lesson.security.model.entity.Products;
import com.security.lesson.security.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
  private final ProductService productService;

  @Autowired
  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @PostMapping
  public ResponseEntity<Products> create(@RequestBody ProductDto productDto) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(productService.create(productDto.toEntity()));
  }

  @GetMapping
  public ResponseEntity<List<Products>> findAll() {
    return ResponseEntity.status(HttpStatus.OK)
        .body(productService.findAll());
  }
}
