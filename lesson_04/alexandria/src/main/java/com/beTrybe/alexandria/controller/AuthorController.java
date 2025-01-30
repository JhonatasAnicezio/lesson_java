package com.beTrybe.alexandria.controller;

import com.beTrybe.alexandria.controller.dto.AuthorCreationDto;
import com.beTrybe.alexandria.controller.dto.AuthorDto;
import com.beTrybe.alexandria.entity.Author;
import com.beTrybe.alexandria.service.AuthorService;
import com.beTrybe.alexandria.service.exception.AuthorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/authors")
public class AuthorController {

  private final AuthorService authorService;

  @Autowired
  public AuthorController(AuthorService authorService) {
    this.authorService = authorService;
  }

  @GetMapping("/{id}")
  public AuthorDto getAuthorById(@PathVariable Long id) throws AuthorNotFoundException {
    return AuthorDto.fromEntity(
        authorService.findById(id)
    );
  }

  @GetMapping
  public List<AuthorDto> getAllAuthors() {
    List<Author> allAuthors = authorService.findAll();
    return allAuthors.stream()
        .map(AuthorDto::fromEntity)
        .toList();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public AuthorDto createAuthor(@RequestBody AuthorCreationDto authorCreationDto) {
    return AuthorDto.fromEntity(
        authorService.createAuthor(authorCreationDto.toEntity())
    );
  }

  @PutMapping("/{id}")
  public AuthorDto updateAuthor(@PathVariable Long id,
                                @RequestBody AuthorCreationDto authorCreationDto) throws AuthorNotFoundException {
    return AuthorDto.fromEntity(
        authorService.updateAuthor(id, authorCreationDto.toEntity())
    );
  }

  @DeleteMapping("/{id}")
  public AuthorDto deleteAuthorById(@PathVariable Long id) throws AuthorNotFoundException {
    return AuthorDto.fromEntity(
        authorService.deleteById(id)
    );
  }
}
