package com.betrybe;

import java.util.Scanner;

public class convertendoTipos {
  public static void main(String[] args) {
    short numeroInteiroPequeno = 10;
    int numeroInteiro = numeroInteiroPequeno;
    long numeroInteiroBemGrande = numeroInteiro;
    float numeroDePontoFlutuante = numeroInteiro;
    double numeroDePontoFlutuanteDuasVezesMaisPreciso = numeroInteiro;

    System.out.println(numeroDePontoFlutuanteDuasVezesMaisPreciso);

    double numeroDePontoFlutuanteC = 40_000_000.49d; // Valor bem grande.
    int numeroInteiroC = (int) numeroDePontoFlutuanteC; // O valor à direita do ponto será perdido.
    short numeroInteiroPequenoC = (short) numeroInteiroC; // O tipo short armazena valores entre -32.768 e 32.767, muita coisa será perdida.

    System.out.println(numeroInteiroPequenoC);

    Scanner scanner = new Scanner(System.in);
    System.out.print("Entre com o número: ");
    String input = scanner.next();

    short numeroInteiroPequenoS = Short.parseShort(input); // Converte para short.
    long numeroInteiroBemGrandeS = Long.parseLong(input); // Converte para long.
    float numeroDePontoFlutuanteS = Float.parseFloat(input); // Converte para float.
    double numeroDePontoFlutuanteComPrecisaoDuplaS = Double.parseDouble(input); // Converte para double.

    System.out.println(numeroInteiroPequenoS);
    System.out.println(numeroInteiroBemGrandeS);
    System.out.println(numeroDePontoFlutuanteS);
    System.out.println(numeroDePontoFlutuanteComPrecisaoDuplaS);

    scanner.close();
  }
}
