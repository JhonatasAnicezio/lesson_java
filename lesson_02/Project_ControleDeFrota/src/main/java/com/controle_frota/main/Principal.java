package com.controle_frota.main;

import com.controle_frota.core.Caminhao;
import com.controle_frota.core.Carro;

public class Principal {

  public static void main(String[] args) {
    Carro c1 = new Carro("RTF 123", 2018);
    Caminhao c2 = new Caminhao("TBR 1234", 2015);

    c1.abastecer("Posto 1", "Carlos", 100);
    c1.abastecer("Posto 2", "Carlos", 200);
    c1.abastecer("Posto 3", "Rodrigo", 300);

    c2.abastecer(null, "Rodrigo", 400);
    c2.abastecer(null, "João", 500);
    c2.abastecer(null, "João", 600);

    c1.listAbastecimento();
    c2.listAbastecimento();
  }
}
