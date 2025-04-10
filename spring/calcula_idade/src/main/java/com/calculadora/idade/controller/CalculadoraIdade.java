package com.calculadora.idade.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraIdade {

	@GetMapping(path = "/{dia}/{mes}/{ano}")
	public int calculaIdade(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer ano) {
		LocalDate dataNascimento = LocalDate.of(ano, mes, dia);
		return (int) dataNascimento.until(LocalDate.now(), ChronoUnit.YEARS);
	}
}