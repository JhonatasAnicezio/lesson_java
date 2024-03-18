package com.betrybe.core;

public class ContaPoupanca {
  protected double saldo;

  public double getSaldo() {
    return saldo;
  }

  public void depositar(double valor) {
    this.saldo += valor;
  }

  public void sacar(double valor) {
    this.saldo -= valor;
  }
}
