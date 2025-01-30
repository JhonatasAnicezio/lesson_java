package com.beTrybe.alexandria.controller.dto;

import com.beTrybe.alexandria.entity.Book;

public record BookCreationDto(String title, String genre) {

  public Book toEntity() {
    return new Book(title, genre);
  }

}