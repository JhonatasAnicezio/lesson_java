package com.betrybe.tech;

public class Application {

  public static void main(String[] args) {
    Laptop laptop = new Laptop("Samsung", 100, 14);
    PowerBank powerBank = new PowerBank();

    plugDevice(laptop);
    plugDevice(powerBank);

    ComputerDevice genericDevice = new Laptop("Apple", 256.0, 13.3);

    if (genericDevice instanceof Laptop) {
      Laptop specificLaptop = (Laptop) genericDevice;
    }
  }

  public static void plugDevice(Chargeable chargeable) {
    System.out.println("A bateria atual é " + chargeable.getBatteryLevel());
    chargeable.charge();
  }
}
