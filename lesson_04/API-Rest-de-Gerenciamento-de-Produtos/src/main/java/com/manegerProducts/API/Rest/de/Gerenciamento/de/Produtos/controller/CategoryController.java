package com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.controller;

import com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.controller.dto.CategoryCreationDto;
import com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.controller.dto.CategoryDto;
import com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.entity.Category;
import com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.service.CategoryService;
import com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.service.exception.CategoryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
  private final CategoryService categoryService;

  @Autowired
  public CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<CategoryDto> findById(@PathVariable Long id) throws CategoryNotFoundException {
    return ResponseEntity.status(HttpStatus.OK)
        .body(CategoryDto.fromEntity(categoryService.findById(id)));
  }

  @GetMapping
  public ResponseEntity<List<CategoryDto>> findAll() {
    return ResponseEntity.status(HttpStatus.OK)
        .body(categoryService.findAll().stream()
            .map(CategoryDto::fromEntity)
            .toList());
  }

  @PostMapping
  public ResponseEntity<CategoryDto> create(@RequestBody CategoryCreationDto categoryCreationDto) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(CategoryDto.fromEntity(categoryService.create(categoryCreationDto.toEntity())));
  }

  @PutMapping("/{id}")
  public ResponseEntity<CategoryDto> update(
      @PathVariable Long id,
      @RequestBody CategoryCreationDto categoryCreationDto
  ) throws CategoryNotFoundException {
    return ResponseEntity.status(HttpStatus.OK)
        .body(CategoryDto.fromEntity(categoryService.update(id, categoryCreationDto.toEntity())));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<CategoryDto> delete(@PathVariable Long id) throws CategoryNotFoundException {
    return ResponseEntity.status(HttpStatus.OK)
        .body(CategoryDto.fromEntity(categoryService.delete(id)));
  }
}
