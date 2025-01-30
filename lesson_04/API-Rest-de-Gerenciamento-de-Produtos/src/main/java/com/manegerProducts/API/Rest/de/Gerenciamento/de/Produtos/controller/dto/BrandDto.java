package com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.controller.dto;

import com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.entity.Brand;

public record BrandDto(Long id, String name) {

  public static BrandDto fromEntity(Brand brand) {
    return new BrandDto(brand.getId(), brand.getName());
  }
}
