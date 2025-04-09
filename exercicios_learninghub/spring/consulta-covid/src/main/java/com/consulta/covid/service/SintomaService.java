package com.consulta.covid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.consulta.covid.model.Sintoma;
import com.consulta.covid.model.repository.SintomaRepository;

public class SintomaService {
	@Autowired
	private SintomaRepository repository;

	public List<Sintoma> findAll() {
		return repository.findAll();
	}

	public List<Sintoma> findByName(String nome) {
		if (nome == null || nome.isEmpty()) {
			throw new RuntimeException("Nome não informado para a busca");
		}
		return repository.findByName(nome);
	}

	public Sintoma findById(Integer codigo) {
		Sintoma sintoma = repository.findById(codigo);
		if (sintoma == null) {
			throw new RuntimeException("Sintoma " + codigo + " não registrado");
		}
		return sintoma;
	}

	public boolean insertSymptom(Sintoma sintoma) {
		return repository.insert(sintoma);
	}
}
