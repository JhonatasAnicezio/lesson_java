package com.betrybe.eletronic;

public class Television {
  int MAX_VOLUME = 30;
  int volume = 0;
  boolean isOn = false;

  String brand;
  String model;
  int size;
  public Television(String brand, String model, int size) {
    this.brand = brand;
    this.model = model;
    this.size = size;
  }

  public void tunOn() {
    System.out.println("Ligando televisão...");
    this.isOn = true;
  }

  public void turnOff() {
    System.out.println("Desligando televisão...");
    this.isOn = false;
  }

  public String info() {
    return "Marca: %s, Modelo: %s, Tamanho: %d, Ligada: %b".formatted(
      brand, model, size, isOn
    );
  }

  public void increaseVolume() {
    if(volume < MAX_VOLUME) {
      volume++;
    }
  }

  public void decreaseVolume() {
    if(volume > 0) {
      volume--;
    }
  }
}
