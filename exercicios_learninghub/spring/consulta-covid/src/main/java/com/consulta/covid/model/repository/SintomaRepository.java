package com.consulta.covid.model.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.consulta.covid.model.Sintoma;

public class SintomaRepository {

	private SintomaRepository repository;

	private Set<Sintoma> sintomas;

	public SintomaRepository() {
		repository = getInstance();
	}

	private SintomaRepository getInstance() {
		if (repository == null) {
			this.sintomas = new HashSet<>();
			return this;
		}
		return repository;
	}

	public List<Sintoma> findAll() {
		return sintomas.stream().toList();
	}
	
	public List<Sintoma> findByName(String nome) {
		return sintomas.stream().filter(s -> nome.equals(s.getNome())).toList();
	}

	public boolean insert(Sintoma sintoma) {
		return sintomas.add(sintoma);
	}

	public Sintoma findById(Integer codigo) {
		return sintomas.stream().filter(s -> codigo.equals(s.getCodigo())).findFirst().orElse(null);
	}

}
