package com.beTrybe.alexandria.service.exception;

public class BookDetailsNotFoundException extends NotFoundException {
  public BookDetailsNotFoundException() {
    super("Detalhes do livro não encontrado!");
  }
}
