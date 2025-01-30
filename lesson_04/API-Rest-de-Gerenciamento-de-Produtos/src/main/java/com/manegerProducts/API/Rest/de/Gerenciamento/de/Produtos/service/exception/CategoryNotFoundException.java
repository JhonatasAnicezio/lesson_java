package com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.service.exception;

public class CategoryNotFoundException extends NotFoundExcetion {
  public CategoryNotFoundException() {
    super("Categoria não encontrada!");
  }
}
