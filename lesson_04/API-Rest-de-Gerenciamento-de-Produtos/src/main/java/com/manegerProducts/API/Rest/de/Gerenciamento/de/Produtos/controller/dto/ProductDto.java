package com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.controller.dto;

import com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.entity.Product;

public record ProductDto(Long id, String name, double price) {

  public static ProductDto fromEntity(Product product) {
    return new ProductDto(product.getId(), product.getName(), product.getPrice());
  }
}
