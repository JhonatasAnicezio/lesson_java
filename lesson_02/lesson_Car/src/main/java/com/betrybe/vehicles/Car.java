package com.betrybe.vehicles;

public class Car {
  String MARCA;
  String MODELO;
  int ANO;

  public Car(String MARCA, String MODELO, int ANO) {
    this.MARCA = MARCA;
    this.MODELO = MODELO;
    this.ANO = ANO;
  }

  public void exibirInformacoes() {
    System.out.println("Marca: " + MARCA + ", Modelo: " + MODELO + ", Ano: " + ANO );
  }
}
