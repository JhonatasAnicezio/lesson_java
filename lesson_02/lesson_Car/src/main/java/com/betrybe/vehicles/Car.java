package com.betrybe.vehicles;

public class Car {
  private String MARCA;
  private String MODELO;
  private int ANO;

  public Car(String MARCA, String MODELO, int ANO) {
    this.MARCA = MARCA;
    this.MODELO = MODELO;
    this.ANO = ANO;
  }

  public void exibirInformacoes() {
    System.out.println("Marca: " + MARCA + ", Modelo: " + MODELO + ", Ano: " + ANO );
  }

  public String getMARCA() {
    return MARCA;
  }

  public String getMODELO() {
    return MODELO;
  }

  public int getANO() {
    return ANO;
  }

}
