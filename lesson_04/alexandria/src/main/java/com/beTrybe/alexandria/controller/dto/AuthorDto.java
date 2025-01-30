package com.beTrybe.alexandria.controller.dto;

import com.beTrybe.alexandria.entity.Author;

public record AuthorDto(Long id, String name, String nationality) {

  public static AuthorDto fromEntity(Author author) {
    return new AuthorDto(
        author.getId(),
        author.getName(),
        author.getNationality()
    );
  }
}
