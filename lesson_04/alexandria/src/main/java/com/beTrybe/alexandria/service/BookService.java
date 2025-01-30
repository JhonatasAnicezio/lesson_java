package com.beTrybe.alexandria.service;

import com.beTrybe.alexandria.entity.Book;
import com.beTrybe.alexandria.repository.BookRepository;
import com.beTrybe.alexandria.service.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
  private final BookRepository bookRepository;

  @Autowired
  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public Book findById(Long id) throws BookNotFoundException {
    return bookRepository.findById(id)
        .orElseThrow(BookNotFoundException::new);
  }

  public List<Book> findAll() {
    return bookRepository.findAll();
  }

  public Book create(Book book) {
    return bookRepository.save(book);
  }

  public Book update(Long id, Book book) throws BookNotFoundException {
    Book bookInDb = findById(id);

    bookInDb.setTitle(book.getTitle());
    bookInDb.setGenre(book.getGenre());

    return bookRepository.save(bookInDb);
  }

  public Book delete(Long id) throws BookNotFoundException {
    Book bookInDb = findById(id);

    bookRepository.deleteById(id);

    return bookInDb;
  }
}
