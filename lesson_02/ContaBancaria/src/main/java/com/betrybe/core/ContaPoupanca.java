package com.betrybe.core;

public class ContaPoupanca extends Conta {

  @Override
  public void sacar(double valor) {
    super.sacar(valor + 2);
  }

  public double simularRendimento() {
    return this.saldo + this.saldo * 0.05;
  }

  public double simularRendimento(double taxa) {
    return this.saldo + this.saldo * 0.05;
  }
}
