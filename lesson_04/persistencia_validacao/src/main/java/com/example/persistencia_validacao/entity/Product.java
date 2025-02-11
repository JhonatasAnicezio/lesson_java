package com.example.persistencia_validacao.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
@Table(name = "products")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Name is required")
  @Size(min = 2, max = 50, message = "Tamanho ta muito estranho")
  private String name;

  @NotBlank(message = "Manufacture Date is required")
  @PastOrPresent(message = "Data de criação invalida")
  private LocalDate manufactureDate;

  @NotBlank(message = "Expiration Date is required")
  @Future(message = "Data de validade incorreta")
  private LocalDate expirationDate;

  public Product() {
  }

  public Product(String name, LocalDate manufactureDate, LocalDate expirationDate) {
    this.name = name;
    this.manufactureDate = manufactureDate;
    this.expirationDate = expirationDate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDate getManufactureDate() {
    return manufactureDate;
  }

  public void setManufactureDate(LocalDate manufactureDate) {
    this.manufactureDate = manufactureDate;
  }

  public LocalDate getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(LocalDate expirationDate) {
    this.expirationDate = expirationDate;
  }
}
