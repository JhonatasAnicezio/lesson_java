package com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.controller;

import com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.controller.dto.BrandCreationDto;
import com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.controller.dto.BrandDto;
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
  public ResponseEntity<BrandDto> findById(@PathVariable Long id) throws BrandNotFoundException {
    return ResponseEntity.status(HttpStatus.OK)
        .body(BrandDto.fromEntity(brandService.findById(id)));
  }

  @GetMapping
  public ResponseEntity<List<BrandDto>> findAll() {
    return ResponseEntity.status(HttpStatus.OK)
        .body(brandService.findAll().stream()
            .map(BrandDto::fromEntity)
            .toList());
  }

  @PostMapping
  public ResponseEntity<BrandDto> create(@RequestBody BrandCreationDto brandCreationDto) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(BrandDto.fromEntity(brandService.create(brandCreationDto.toEntity())));
  }

  @PutMapping("/{id}")
  public ResponseEntity<BrandDto> update(
      @PathVariable Long id,
      @RequestBody BrandCreationDto brandCreationDto
  ) throws BrandNotFoundException {
    return ResponseEntity.status((HttpStatus.OK))
        .body(BrandDto.fromEntity(brandService.update(id, brandCreationDto.toEntity())));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<BrandDto> delete(@PathVariable Long id) throws BrandNotFoundException {
    return ResponseEntity.status(HttpStatus.OK)
        .body(BrandDto.fromEntity(brandService.delete(id)));
  }
}
