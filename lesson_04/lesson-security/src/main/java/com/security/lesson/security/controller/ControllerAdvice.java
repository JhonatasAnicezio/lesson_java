package com.security.lesson.security.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
  @ExceptionHandler(Throwable.class)
  public ResponseEntity<String> handleException(Throwable e) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(e.getMessage());
  }
}
