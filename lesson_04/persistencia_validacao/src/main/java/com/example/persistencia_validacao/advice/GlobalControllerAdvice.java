package com.example.persistencia_validacao.advice;

import com.example.persistencia_validacao.service.exception.ProductNotFound;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.core.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalControllerAdvice {

  @ExceptionHandler({
      ProductNotFound.class
  })
  public ResponseEntity<String> handleNotFound(Exception exception) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(exception.getMessage());
  }

  @ExceptionHandler({
      ConstraintViolationException.class
  })
  public ResponseEntity<Map<String, String>> handleValidationEntity(ConstraintViolationException exception) {
    Map<String, String> errors = new HashMap<>();

    for(ConstraintViolation<?> violation: exception.getConstraintViolations()) {
      errors.put(violation.getPropertyPath().toString(), violation.getMessage());
    }

    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(errors);
  }
}
