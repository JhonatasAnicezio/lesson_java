package com.betrybe.eletronic;

public class Aplication {

  public static void main(String[] args) {
    Television television = new Television("Phillips","LCD", 32);

    television.tunOn();
    television.turnOff();

    System.out.println(television.info());
  }
}
