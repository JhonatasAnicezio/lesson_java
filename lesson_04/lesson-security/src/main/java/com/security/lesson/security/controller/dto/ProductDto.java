package com.security.lesson.security.controller.dto;

import com.security.lesson.security.model.entity.Products;

public record ProductDto(String name, double price) {
  public Products toEntity() {
    return new Products(name, price);
  }
}
