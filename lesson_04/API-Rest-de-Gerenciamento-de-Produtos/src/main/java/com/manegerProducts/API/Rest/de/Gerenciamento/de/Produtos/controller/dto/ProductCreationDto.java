package com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.controller.dto;

import com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.entity.Product;

public record ProductCreationDto(String name, double price) {

  public Product toEntity() {
    return new Product(name, price);
  }
}
