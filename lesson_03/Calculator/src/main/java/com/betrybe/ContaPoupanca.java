package com.betrybe;

public class ContaPoupanca {
  private int saldo = 0;

  public int depositar(int valor) {
    this.saldo += valor;
    return valor;
  }
}
