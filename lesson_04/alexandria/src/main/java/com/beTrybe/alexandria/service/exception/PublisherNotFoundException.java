package com.beTrybe.alexandria.service.exception;

public class PublisherNotFoundException extends NotFoundException{
  public PublisherNotFoundException() {
    super("Editora não encontrada!");
  }
}
