package com.beTrybe.alexandria.service;

import com.beTrybe.alexandria.entity.Book;
import com.beTrybe.alexandria.entity.BookDetails;
import com.beTrybe.alexandria.repository.BookDetailsRepository;
import com.beTrybe.alexandria.repository.BookRepository;
import com.beTrybe.alexandria.service.exception.BookDetailsNotFoundException;
import com.beTrybe.alexandria.service.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
  private final BookRepository bookRepository;
  private final BookDetailsRepository bookDetailsRepository;

  @Autowired
  public BookService(BookRepository bookRepository, BookDetailsRepository bookDetailsRepository) {
    this.bookRepository = bookRepository;
    this.bookDetailsRepository = bookDetailsRepository;
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

  public BookDetails createBookDetails(Long bookId, BookDetails bookDetails) throws BookNotFoundException {
    Book bookInDb = findById(bookId);

    bookDetails.setBook(bookInDb);

    return bookDetailsRepository.save(bookDetails);
  }

  public BookDetails findBookDetails(Long bookId) throws BookNotFoundException, BookDetailsNotFoundException {
    Book bookInb = findById(bookId);

    Optional<BookDetails> bookDetails = Optional.ofNullable(bookInb.getBookDetails());

    return bookDetails.orElseThrow(BookDetailsNotFoundException::new);
  }

  public BookDetails update(Long bookId, BookDetails bookDetails) throws BookNotFoundException, BookDetailsNotFoundException {
    BookDetails bookDetailFromDb = findBookDetails(bookId);

    bookDetailFromDb.setSummary(bookDetails.getSummary());
    bookDetailFromDb.setPageCount(bookDetails.getPageCount());
    bookDetailFromDb.setYear(bookDetails.getYear());
    bookDetailFromDb.setIsbn(bookDetails.getIsbn());

    return bookDetailsRepository.save(bookDetailFromDb);
  }

  public BookDetails deleteBookDetails(Long bookId) throws BookDetailsNotFoundException, BookNotFoundException {
    Book book = findById(bookId);
    BookDetails bookDetails = Optional.ofNullable(book.getBookDetails())
        .orElseThrow(BookDetailsNotFoundException::new);

    book.setBookDetails(null);
    bookDetails.setBook(null);

    bookDetailsRepository.delete(bookDetails);

    return bookDetails;
  }
}
