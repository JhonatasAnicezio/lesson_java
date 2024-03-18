package com.betrybe.main;

import com.betrybe.core.ContaCorrente;
import com.betrybe.core.ContaPoupanca;

public class Main {

  public static void main(String[] args) {
    ContaPoupanca cp = new ContaPoupanca();
    ContaCorrente cc = new ContaCorrente();

    cp.depositar(1000);
    cc.depositar(1000);

    cp.sacar(500);
    cc.sacar(500);

    System.out.println("O saldo da sua conta poupança é de: " + cp.getSaldo());
    System.out.println("O saldo da sua conta corrente é de: " + cc.getSaldo());

    System.out.println(cp.simularRendimento());
    System.out.println(cp.simularRendimento(100));
  }
}
