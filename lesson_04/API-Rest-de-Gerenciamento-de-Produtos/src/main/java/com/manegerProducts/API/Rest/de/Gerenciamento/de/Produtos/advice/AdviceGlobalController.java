package com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.advice;

import com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.service.exception.NotFoundExcetion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdviceGlobalController {

  @ExceptionHandler
  public ResponseEntity<String> handlerNotFound(NotFoundExcetion excetion) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(excetion.getMessage());
  }
}
