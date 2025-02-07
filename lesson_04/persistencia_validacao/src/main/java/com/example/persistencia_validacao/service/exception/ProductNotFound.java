package com.example.persistencia_validacao.service.exception;

public class ProductNotFound extends Exception {
  public ProductNotFound(String message) {
    super("Produto não encontrado!");
  }
}
