package com.controle_frota.core;

public class Caminhao extends Veiculo {

  protected Caminhao(String placa, int anoFabricacao) {
    super(placa, anoFabricacao);
    this.setCombustivel("Diesel");
  }

  @Override
  public void abastecer(String local, String motorista, double valor) {
    this.getAbastecimento().add(String.format("Local: base, Motorista: %s, Valor: %d", motorista, valor));
  }
}
