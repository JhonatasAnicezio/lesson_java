package com.betrybe.vehicles;

public class App {

  public static void main(String[] args) {
    System.out.println("Iniciando aplicação...");
    System.out.println("A quantidade de carros instanciados é: " + Car.quantidadeDeCarros());
    Car parati = new Car("wolksvaguem", "parati", 1978);
    Car hondaCivic = new Car("Honda", "Civic", 2012);
    parati.exibirInformacoes();
    System.out.println("A quantidade de carros instanciados é: " + Car.quantidadeDeCarros());
  }
}
