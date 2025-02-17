package com.security.lesson.security.controller;

import com.security.lesson.security.controller.dto.AuthDto;
import com.security.lesson.security.controller.dto.PersonCreateDto;
import com.security.lesson.security.controller.dto.Token;
import com.security.lesson.security.model.entity.Person;
import com.security.lesson.security.model.repository.PersonRepository;
import com.security.lesson.security.service.JwtService;
import com.security.lesson.security.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
  private final PersonService personService;
  private final AuthenticationManager authenticationManager;
  private final JwtService jwtService;

  @Autowired
  public AuthController(
      PersonService personService,
      AuthenticationManager authenticationManager,
      JwtService jwtService) {
    this.personService = personService;
    this.authenticationManager = authenticationManager;
    this.jwtService = jwtService;
  }

  @PostMapping("/register")
  public ResponseEntity<String> createPerson(@RequestBody PersonCreateDto personCreateDto) {
    Person newPerson = personService.create(personCreateDto.toEntity());

    return ResponseEntity.status(HttpStatus.CREATED)
        .body("Boas vindas a nossa api %s".formatted(newPerson.getUsername()));
  }

  @PostMapping("/login")
  public ResponseEntity<Token> login(@RequestBody AuthDto authDto) {
    UsernamePasswordAuthenticationToken usernamePassword =
        new UsernamePasswordAuthenticationToken(authDto.username(), authDto.password());

    Authentication auth = authenticationManager.authenticate(usernamePassword);

    Token token = new Token(jwtService.createToken(auth.getName()));

    return ResponseEntity.status(HttpStatus.OK)
        .body(token);
  }
}
