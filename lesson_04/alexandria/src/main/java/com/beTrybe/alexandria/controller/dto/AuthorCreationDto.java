package com.beTrybe.alexandria.controller.dto;

import com.beTrybe.alexandria.entity.Author;

public record AuthorCreationDto(String name, String nationality) {

  public Author toEntity() {
    return new Author(name, nationality);
  }
}