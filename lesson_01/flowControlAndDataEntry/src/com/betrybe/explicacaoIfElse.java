package com.betrybe;

import java.util.Random;

public class explicacaoIfElse {
  public static void main(String[] args) {
    int resultado = resultadoTest();
    if (resultado > 7) {
      System.out.println("PARABENS! VOCÊ ESTÁ NA PROXIMA ETAPA!");
    } else if (resultado == 7) {
      System.out.println("QUASE! TENTE DE NOVO!");
    } else {
      System.out.println("POXA, NÃO FOI DESSA VEZ. ATÉ A PROXIMA!");
    }
  }

  static int resultadoTest() {
    return new Random().ints(0, 11).findFirst().getAsInt();
  }
}
