package com.betrybe;

import java.util.Random;

public class aprendendoDoWhile {
  public static void main(String[] args) {
    int tentativas = 0;
    int atendeu = 0;
    String log;

    do {
      log = "Ligando para o candidato selecionado... \n";

      atendeu = new Random().ints(0, 2).findFirst().getAsInt();
      tentativas += 1;
    } while (atendeu == 0 && tentativas < 3);

    log = "O Candidato atendeu na tentativa " + tentativas;
    System.out.println(log);
  }
}
