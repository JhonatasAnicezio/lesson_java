package com.manegerProducts.API.Rest.de.Gerenciamento.de.Produtos.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "brands")
public class Brand {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  public Brand() {
  }

  public Brand(String name) {
    this.name = name;
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
}
