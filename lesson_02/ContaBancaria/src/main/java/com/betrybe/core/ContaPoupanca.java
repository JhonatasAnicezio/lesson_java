package com.betrybe.core;

public class ContaPoupanca extends Conta {

  @Override
  public void sacar(double valor) {
    super.sacar(valor + 2);
  }
}
