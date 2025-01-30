package com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.controller;

import com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.controller.dto.ProductCreationDto;
import com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.controller.dto.ProductDto;
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
  public ResponseEntity<ProductDto> findById(@PathVariable Long id) throws ProductNotFoundException {
    return ResponseEntity.status(HttpStatus.OK)
        .body(ProductDto.fromEntity(productService.findById(id)));
  }

  @GetMapping
  public ResponseEntity<List<ProductDto>> findAll() {
    return ResponseEntity.status(HttpStatus.OK)
        .body(productService.findByAll().stream()
            .map(ProductDto::fromEntity)
            .toList());
  }

  @PostMapping
  public ResponseEntity<ProductDto> create(@RequestBody ProductCreationDto productCreationDto) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(ProductDto.fromEntity(productService.create(productCreationDto.toEntity())));
  }

  @PutMapping
  public ResponseEntity<ProductDto> update(
      @PathVariable Long id,
      @RequestBody ProductCreationDto productCreationDto
  ) throws ProductNotFoundException {
    return ResponseEntity.status(HttpStatus.OK)
        .body(ProductDto.fromEntity(productService.update(id, productCreationDto.toEntity())));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<ProductDto> delete(@PathVariable Long id) throws ProductNotFoundException {
    return ResponseEntity.status(HttpStatus.OK)
        .body(ProductDto.fromEntity(productService.delete(id)));
  }
}
