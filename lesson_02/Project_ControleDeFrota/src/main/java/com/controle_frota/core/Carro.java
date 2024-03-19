package com.controle_frota.core;

public class Carro extends Veiculo {

  public Carro(String placa, int anoFabricacao) {
    super(placa, anoFabricacao);
    this.setCombustivel("Flex");
  }
  @Override
  public void abastecer(String local, String motorista, double valor) {
    this.getAbastecimento().add(String.format("Local: %s, Motorista: %s, Valor: %d", local, motorista, valor));
  }
}
