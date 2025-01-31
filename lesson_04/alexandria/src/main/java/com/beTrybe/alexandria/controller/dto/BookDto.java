package com.beTrybe.alexandria.controller.dto;

import com.beTrybe.alexandria.entity.Book;

public record BookDto(
    Long id,
    String title,
    String genre,
    PublisherDto publisher
) {

  public static BookDto fromEntity(Book book) {
    PublisherDto publisherDto = book.getPublisher() != null ?
        PublisherDto.fromEntity(book.getPublisher()) : null;

    return new BookDto(
        book.getId(),
        book.getTitle(),
        book.getGenre(),
        publisherDto
    );
  }

}