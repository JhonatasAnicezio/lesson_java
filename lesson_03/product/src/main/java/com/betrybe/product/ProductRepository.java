package com.betrybe.product;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
  private DataBase dataBase;

  public ProductRepository(DataBase dataBase) {
    this.dataBase = dataBase;
  }
  public String getMessage() {
    return "Mensagem: produto retornado";
  }
}
