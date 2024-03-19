package com.betrybe.tech;

public class Application {

  public static void main(String[] args) {
    Laptop laptop = new Laptop("Samsung", 100, 14);
    Desktop desktop = new Desktop("Dell", 500);

    checkDevice(laptop);
    checkDevice(desktop);
  }

  public static void checkDevice(ComputerDevice device) {
    System.out.println("Verificando dispositivo de marca " + device.getBrand());
    device.bootUp();
  }
}
