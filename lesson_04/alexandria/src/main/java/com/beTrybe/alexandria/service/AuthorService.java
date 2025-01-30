package com.beTrybe.alexandria.service;

import com.beTrybe.alexandria.entity.Author;
import com.beTrybe.alexandria.repository.AuthorRepository;
import com.beTrybe.alexandria.service.exception.AuthorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
  private final AuthorRepository authorRepository;

  @Autowired
  public AuthorService(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  public Author findById(Long id) throws AuthorNotFoundException {
    return authorRepository.findById(id)
        .orElseThrow(AuthorNotFoundException::new);
  }

  public List<Author> findAll() {
    return authorRepository.findAll();
  }

  public Author createAuthor(Author newAuthor) {
    return authorRepository.save(newAuthor);
  }

  public Author updateAuthor(Long id, Author author) throws AuthorNotFoundException {
    Author authorFromDb = findById(id);

    authorFromDb.setName(author.getName());
    authorFromDb.setNationality(author.getNationality());

    return authorRepository.save(authorFromDb);
  }

  public Author deleteById(Long id) throws AuthorNotFoundException {
    Author authorFromDb = findById(id);

    authorRepository.deleteById(id);

    return authorFromDb;
  }
}
