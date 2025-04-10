package com.bootcamp.meli.codigo_morse.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.meli.codigo_morse.constantes.CodigoMorseEnum;

@RestController
@RequestMapping(path = "conversor")
public class ConversorController {
	private Map<String, CodigoMorseEnum> conversorMap = new HashMap<String, CodigoMorseEnum>();

	@GetMapping(path = "/{codigoMorse}")
	public String converter(@PathVariable String codigoMorse) {
		populaMap();
		String[] codigos = codigoMorse.split(" ");
		StringBuilder builder = new StringBuilder();
		for (String codigo : codigos) {
			String textoConvertido = converteCodigoMorse(codigo);
			builder.append(textoConvertido);
		}
		return builder.toString();
	}

	private String converteCodigoMorse(String codigoMorse) {
		CodigoMorseEnum alphabet = conversorMap.get(codigoMorse);
		if (CodigoMorseEnum.INTERROGACAO.equals(alphabet) || alphabet == null) {
			return "?";
		}
		if (CodigoMorseEnum.EXCLAMACAO.equals(alphabet)) {
			return "!";
		}
		if (CodigoMorseEnum.PONTO.equals(alphabet)) {
			return ".";
		}
		if (CodigoMorseEnum.VIRGULA.equals(alphabet)) {
			return ",";
		}

		return alphabet.name();
	}

	private void populaMap() {
		for (CodigoMorseEnum letter : CodigoMorseEnum.values()) {
			conversorMap.put(letter.getValor(), letter);
		}
	}

}
