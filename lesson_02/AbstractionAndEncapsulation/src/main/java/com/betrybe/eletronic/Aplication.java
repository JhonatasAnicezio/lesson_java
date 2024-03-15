package com.betrybe.eletronic;

public class Aplication {

  public static void main(String[] args) {
    Television television = new Television("Phillips","LCD", 32);

    System.out.println("A televisão está ligada?");
    System.out.println(television.isOn());

    System.out.println("O volume atual é:");
    System.out.println(television.getVolume());

    System.out.println(television.info());

    System.out.println("Modelo antigo:");
    System.out.println(television.getModel());

    television.setModel("LCD-Ultra");

    System.out.println("Modelo novo:");
    System.out.println(television.getModel());
  }
}
