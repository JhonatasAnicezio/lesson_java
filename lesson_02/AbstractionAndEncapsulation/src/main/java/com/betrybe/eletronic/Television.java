package com.betrybe.eletronic;

class Television {
  private int MAX_VOLUME = 30;
  private int volume = 0;
  private boolean isOn = false;

  private String brand;
  private String model;
  private int size;
  public Television(String brand, String model, int size) {
    this.brand = brand;
    this.model = model;
    this.size = size;
  }

  void tunOn() {
    System.out.println("Ligando televisão...");
    this.isOn = true;
  }

  void turnOff() {
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

  public boolean isOn() {
    return isOn;
  }

  public String getBrand() {
    return brand;
  }

  public String getModel() {
    return model;
  }

  public int getSize() {
    return size;
  }

  public int getVolume() {
    return volume;
  }
}
