package com.betrybe.vehicles;

public class Car {
  private String MARCA;
  private String MODELO;
  private int ANO;
  private static int contador = 0;

  public Car(String MARCA, String MODELO, int ANO) {
    this.MARCA = MARCA;
    this.MODELO = MODELO;
    this.ANO = ANO;

    contador++;
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

  public static int quantidadeDeCarros() {
    return contador;
  }
}
