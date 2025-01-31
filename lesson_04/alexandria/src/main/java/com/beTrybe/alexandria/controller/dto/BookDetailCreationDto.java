package com.beTrybe.alexandria.controller.dto;

import com.beTrybe.alexandria.entity.BookDetails;

public record BookDetailCreationDto(
    String summary,
    Integer pageCount,
    String year,
    String isbn) {

  public BookDetails toEntity() {
    return new BookDetails(summary, pageCount, year, isbn);
  }
}
