package com.betrybe;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ContaPoupancaTest {
  @Test
  void testDepositar() {
    ContaPoupanca contaPoupanca = new ContaPoupanca();
    assertEquals(3000, contaPoupanca.depositar(3000));
  }

  @Test
  void testSacar() {
    ContaPoupanca contaPoupanca = new ContaPoupanca();

    contaPoupanca.depositar(3000);
    assertEquals(1000, contaPoupanca.sacar(2000));
  }

  @Test
  void testVerSaldo() {
    ContaPoupanca contaPoupanca = new ContaPoupanca();

    contaPoupanca.depositar(3000);
    assertEquals(3000, contaPoupanca.verSaldo());
  }
}
