package com.betrybe;

public class estruturasDeRepeticao {
  public static void main(String[] args) {
    int numero;
    String log;

    for (numero = 1; numero <= 10; numero += 1) {
      log = "O numero atual é:" + numero + "\n";
      System.out.println(log);
    }

    studantList();
    explicandoForEach();
  }

  static void studantList() {
    String[] alunos = { "MARCOS", "ALINE", "LUCAS", "PATRICIA" };
    String log;

    int totalAlunos = alunos.length;

    log = "A lista de chamadas possui" + totalAlunos + "alunos \n";

    int matricula;
    for (int posicao = 0; posicao < totalAlunos; posicao++) {
      matricula = posicao + 1;
      log = "Matricula" + matricula + "Aluno:" + alunos[posicao] + "\n";
      System.out.println(log);
    }
  }

  static void explicandoForEach() {
    String[] alunos = { "MARCOS", "ALINE", "LUCAS", "PATRICIA" };
    int[] arrayInteiros = new int[4];

    for (String aluno: alunos) {
      System.out.println("Boas vindas aluno(a): " + aluno);
    }
  }
}
