package com.betrybe.oladevtools;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ola-devtools")
public class OlaDevtoolsController {
  @GetMapping
  public String hello() {
    return "Olá, Dev tools!!";
  }
}
