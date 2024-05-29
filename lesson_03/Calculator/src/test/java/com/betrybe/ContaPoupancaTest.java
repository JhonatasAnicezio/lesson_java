package com.betrybe;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ContaPoupancaTest {
  @Test
  void testDepositar() {
    ContaPoupanca contaPoupanca = new ContaPoupanca();
    assertEquals(3000, contaPoupanca.depositar(3000));
  }
}
