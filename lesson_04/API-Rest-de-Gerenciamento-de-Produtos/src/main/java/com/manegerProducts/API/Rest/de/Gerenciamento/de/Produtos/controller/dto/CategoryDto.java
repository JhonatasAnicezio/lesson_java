package com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.controller.dto;

import com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.entity.Category;

public record CategoryDto(Long id, String name) {

  public static CategoryDto fromEntity(Category category) {
    return new CategoryDto(category.getId(), category.getName());
  }
}
