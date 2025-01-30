package com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.controller.dto;

import com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.entity.Brand;

public record BrandCreationDto(String name) {

  public Brand toEntity() {
    return new Brand(name);
  }
}
