package com.betrybe.core;

public class ConcaCorrente extends Conta {

  @Override
  public void sacar(double valor) {
    super.sacar(valor + valor * 0.05);
  }
}
