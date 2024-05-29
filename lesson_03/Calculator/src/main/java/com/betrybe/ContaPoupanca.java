package com.betrybe;

public class ContaPoupanca {
  private int saldo = 0;

  public int depositar(int valor) {
    this.saldo += valor;
    return valor;
  }

  public int sacar(int valor) {
    this.saldo -= valor;
    return saldo;
  }

  public int verSaldo() {
    return this.saldo;
  }
}
