package com.controle_frota.core;

public class Caminhao extends Veiculo implements Transportador {

  public Caminhao(String placa, int anoFabricacao) {
    super(placa, anoFabricacao);
    this.setCombustivel("Diesel");
  }

  @Override
  public void abastecer(String local, String motorista, double valor) {
    this.getAbastecimento().add(String.format("Local: base, Motorista: %s, Valor: %.2f", motorista, valor));
  }

  @Override
  public String transportar(String origem, String destino) {
    return String.format("Veiculo de placa %s, vai tranportar carda de %s a %s", this.getPlaca(), origem, destino);
  }
}
