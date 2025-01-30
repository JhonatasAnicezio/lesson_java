package com.beTrybe.alexandria.service.exception;

public class AuthorNotFoundException extends NotFoundException{
  public AuthorNotFoundException() {
    super("Autor não encontrado!");
  }
}
