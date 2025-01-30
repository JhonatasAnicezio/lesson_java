package com.beTrybe.alexandria.controller;


import com.beTrybe.alexandria.controller.dto.BookCreationDto;
import com.beTrybe.alexandria.controller.dto.BookDto;
import com.beTrybe.alexandria.entity.Book;
import com.beTrybe.alexandria.service.BookService;
import com.beTrybe.alexandria.service.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookController {

  private final BookService bookService;

  @Autowired
  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping("/{id}")
  public BookDto getBookById(@PathVariable Long id) throws BookNotFoundException {
    return BookDto.fromEntity(
        bookService.findById(id)
    );
  }

  @GetMapping
  public List<BookDto> getAllBooks() {
    List<Book> allBooks = bookService.findAll();
    return allBooks.stream()
        .map(BookDto::fromEntity)
        .toList();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public BookDto createBook(@RequestBody BookCreationDto bookCreationDto) {
    return BookDto.fromEntity(
        bookService.create(bookCreationDto.toEntity())
    );
  }

  @PutMapping("/{id}")
  public BookDto updateBook(@PathVariable Long id,
                            @RequestBody BookCreationDto bookCreationDto) throws BookNotFoundException {
    return BookDto.fromEntity(
        bookService.update(id, bookCreationDto.toEntity())
    );
  }

  @DeleteMapping("/{id}")
  public BookDto deleteBookById(@PathVariable Long id) throws BookNotFoundException {
    return BookDto.fromEntity(
        bookService.delete(id)
    );
  }
}
