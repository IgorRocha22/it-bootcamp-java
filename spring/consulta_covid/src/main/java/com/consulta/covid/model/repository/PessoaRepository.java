package com.consulta.covid.model.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.consulta.covid.model.Pessoa;

@Repository
public class PessoaRepository {

	private PessoaRepository repository;

	private Set<Pessoa> pessoas;

	public PessoaRepository() {
		repository = getInstance();
	}

	private PessoaRepository getInstance() {
		if (repository == null) {
			this.pessoas = new HashSet<>();
			return this;
		}
		return repository;
	}

	public List<Pessoa> findByRiskGroup() {
		return pessoas.stream().filter(p -> p.getIdade() > 60 && p.getSintomas().size() > 0).toList();
	}

	public boolean insert(Pessoa pessoa) {
		return this.pessoas.add(pessoa);
	}
}
