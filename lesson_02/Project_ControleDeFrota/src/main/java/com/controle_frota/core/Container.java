package com.controle_frota.core;

public class Container implements Transportador {
  private String modelo;
  private double capacidade;

  public Container(String modelo, double capacidade) {
    this.modelo = modelo;
    this.capacidade = capacidade;
  }
  @Override
  public String transportar(String origem, String destino) {
    return String.format("Esse container será usado para transportar a carga de %s para %s", origem, destino);
  }
}
