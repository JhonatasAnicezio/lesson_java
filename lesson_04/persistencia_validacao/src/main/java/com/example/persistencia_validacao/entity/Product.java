package com.example.persistencia_validacao.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "produtos")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private LocalDate manufactureDate;
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
