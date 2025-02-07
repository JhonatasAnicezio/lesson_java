package com.example.persistencia_validacao;

import org.springframework.boot.SpringApplication;

public class TestPersistenciaValidacaoApplication {

	public static void main(String[] args) {
		SpringApplication.from(PersistenciaValidacaoApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
