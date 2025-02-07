package com.example.persistencia_validacao.service.exception;

public class ProductNotFound extends Exception {
  public ProductNotFound() {
    super("Produto não encontrado!");
  }
}
