package com.security.lesson.security.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Products {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private double price;

  public Products() {
  }

  public Products(String name, double price) {
    this.name = name;
    this.price = price;
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

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }
}
