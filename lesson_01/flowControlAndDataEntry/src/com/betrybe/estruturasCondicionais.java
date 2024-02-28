package com.betrybe;

public class estruturasCondicionais {
  public static void main(String[] args) {
    double mediaFinal = 2;
    String resultado = "INDEFINIDO";

    if (mediaFinal >= 7) {
      resultado = "APROVADO";
    } else if (mediaFinal >= 6.0) {
      resultado = "REALIZAR PROVA BONUS";
    } else {
      resultado = "REPROVADA";
    }

    System.out.println(resultado);
  }
}
