package com.example.persistencia_validacao.controller.dto;

import com.example.persistencia_validacao.entity.Product;

import java.time.LocalDate;

public record ProductCreationDto(String name, LocalDate manufactureDate, LocalDate expirationDate) {
  public Product toEntity() {
    return new Product(name, manufactureDate, expirationDate);
  }
}
