package com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.controller;

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
  public ResponseEntity<Category> findById(@PathVariable Long id) throws CategoryNotFoundException {
    return ResponseEntity.status(HttpStatus.OK)
        .body(categoryService.findById(id));
  }

  @GetMapping
  public ResponseEntity<List<Category>> findAll() {
    return ResponseEntity.status(HttpStatus.OK)
        .body(categoryService.findAll());
  }

  @PostMapping
  public ResponseEntity<Category> create(@RequestBody Category category) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(categoryService.create(category));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Category> update(
      @PathVariable Long id,
      @RequestBody Category category
  ) throws CategoryNotFoundException {
    return ResponseEntity.status(HttpStatus.OK)
        .body(categoryService.update(id, category));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Category> delete(@PathVariable Long id) throws CategoryNotFoundException {
    return ResponseEntity.status(HttpStatus.OK)
        .body(categoryService.delete(id));
  }
}
