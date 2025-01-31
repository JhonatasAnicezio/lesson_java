package com.beTrybe.alexandria.controller.dto;

import com.beTrybe.alexandria.entity.BookDetails;

public record BookDetailDto(
    Long id,
    String summary,
    Integer pageCount,
    String year,
    String isbn) {

  public static BookDetailDto fromEntity(BookDetails bookDetail) {
    return new BookDetailDto(
        bookDetail.getId(),
        bookDetail.getSummary(),
        bookDetail.getPageCount(),
        bookDetail.getYear(),
        bookDetail.getIsbn()
    );
  }
}
