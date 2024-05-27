package com.betrybe.exception.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class PessoaController {
  private String id;
  private String nome;

  @GetMapping("/pessoas/{nome}")
  public Pessoa buscarPessoaPeloNome(@PathVariable String nome) {
    return pessoaService.buscarPessoaPeloNome(nome);
  }
}
