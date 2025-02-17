package com.security.lesson.security.controller.dto;

import com.security.lesson.security.model.entity.Person;

public record PersonCreateDto(String username, String password) {
  public Person toEntity() {
    return new Person(username, password);
  }
}
