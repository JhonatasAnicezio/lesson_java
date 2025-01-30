package com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.controller;

import com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.entity.Brand;
import com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.service.BrandService;
import com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.service.exception.BrandNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
  private final BrandService brandService;

  @Autowired
  public BrandController(BrandService brandService) {
    this.brandService = brandService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<Brand> findById(@PathVariable Long id) throws BrandNotFoundException {
    return ResponseEntity.status(HttpStatus.OK)
        .body(brandService.findById(id));
  }

  @GetMapping
  public ResponseEntity<List<Brand>> findAll() {
    return ResponseEntity.status(HttpStatus.OK)
        .body(brandService.findAll());
  }

  @PostMapping
  public ResponseEntity<Brand> create(@RequestBody Brand brand) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(brandService.create(brand));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Brand> update(
      @PathVariable Long id,
      @RequestBody Brand brand
  ) throws BrandNotFoundException {
    return ResponseEntity.status((HttpStatus.OK))
        .body(brandService.update(id, brand));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Brand> delete(@PathVariable Long id) throws BrandNotFoundException {
    return ResponseEntity.status(HttpStatus.OK)
        .body(brandService.delete(id));
  }
}
