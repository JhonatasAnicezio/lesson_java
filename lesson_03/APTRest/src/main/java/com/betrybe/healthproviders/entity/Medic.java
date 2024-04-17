package com.betrybe.healthproviders.entity;

public class Medic {
  private long id;
  private String name;
  private String specialty;
  private String cpf;

  public Medic(Long id, String name, String specialty, String cpf) {
    this.id = id;
    this.name = name;
    this.specialty = specialty;
    this.cpf = cpf;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSpecialty() {
    return specialty;
  }

  public void setSpecialty(String specialty) {
    this.specialty = specialty;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
}
