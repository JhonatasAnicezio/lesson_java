package com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.service.exception;

public class BrandNotFoundException extends NotFoundExcetion {
  public BrandNotFoundException() {
    super("Marca não encontrada!");
  }
}
