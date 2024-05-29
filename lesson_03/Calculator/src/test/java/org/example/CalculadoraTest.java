package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes da classe Calculadora")
class CalculadoraTest {

  @Test
  @DisplayName("Teste do método somar")
  public void testeSomar() {
    Calculadora cal = new Calculadora();
    assertEquals(34, cal.somar(32, 2));
  }

  @Test@DisplayName("Teste do método subtrair")
  public void testeSubtrais() {
    Calculadora cal = new Calculadora();
    assertEquals(1, cal.subtrair(3, 2));
  }
}
