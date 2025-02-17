package com.security.lesson.security.service.exception;

public class ProductNotFoundException extends Exception {
  public ProductNotFoundException() {
    super("Não foi possivel encontrar o seu produto!");
  }
}
