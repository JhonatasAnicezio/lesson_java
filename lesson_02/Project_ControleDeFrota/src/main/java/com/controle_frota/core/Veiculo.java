package com.controle_frota.core;

import java.util.ArrayList;

public abstract class Veiculo {
  private String placa;
  private int anoFabricacao;
  private String combustivel;
  private ArrayList<String> abastecimento;

  protected Veiculo(String placa, int anoFabricacao) {
    this.placa = placa;
    this.anoFabricacao = anoFabricacao;
    this.abastecimento = new ArrayList<>();
  }

  public String getPlaca() {
    return placa;
  }

  public void setPlaca(String placa) {
    this.placa = placa;
  }

  public int getAnoFabricacao() {
    return anoFabricacao;
  }

  public void setAnoFabricacao(int anoFabricacao) {
    this.anoFabricacao = anoFabricacao;
  }

  public String getCombustivel() {
    return combustivel;
  }

  public void setCombustivel(String combustivel) {
    this.combustivel = combustivel;
  }

  public ArrayList<String> getAbastecimento() {
    return abastecimento;
  }

  public void setAbastecimento(ArrayList<String> abastecimento) {
    this.abastecimento = abastecimento;
  }

  public abstract void abastecer(String local, String motorista, double valor);

  public void listAbastecimento() {
    System.out.println("+-- Lista abastecimento para o veiculos: " + this.placa + "--+");
    for (String abastecimento : this.abastecimento) {
      System.out.println("|" + abastecimento + "\t|");
    }
    System.out.println("+------------------------ Fim -----------------------+");
  }
}
