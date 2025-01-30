package com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.controller.dto;

import com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.entity.Category;

public record CategoryCreationDto(String name) {

  public Category toEntity() {
    return new Category(name);
  }
}
