package com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.service.exception;

public class ProductNotFoundException extends NotFoundExcetion {
  public ProductNotFoundException() {
    super("Produto não encontrado!");
  }
}
