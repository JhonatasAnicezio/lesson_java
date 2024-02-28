package com.betrybe;

import java.util.Scanner;

public class usandoScanner {
  public static void main(String[] args) {
    Scanner scaner = new Scanner(System.in);
    System.out.print("Qual o seu nome: ");
    String nome = scaner.next();
    System.out.println("Boas vindas, " + nome + "!");

    System.out.print("Entre com o primeiro número: ");
    String input1 = scaner.next();
    System.out.print("Entre com o segundo número: ");
    String input2 = scaner.next();

    int n1 = Integer.parseInt(input1);
    int n2 = Integer.parseInt(input2);

    int resultado = n1 + n2;
    System.out.println("O resultado da soma é: " + resultado);

    scaner.close();
  }
}