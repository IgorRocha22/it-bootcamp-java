package com.esportistas.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.esportistas.model.Esporte;
import com.esportistas.model.Pessoa;

@Repository
public class PessoaRepository {

	@Autowired
	private EsporteRepository esporteRepo;

	private Set<Pessoa> pessoas = new HashSet<Pessoa>();

	public List<Pessoa> findAll() {
		List<Pessoa> list = pessoas.stream().toList();
		fetchEsporte(list);
		return list;

	}

	private void fetchEsporte(List<Pessoa> list) {
		for (Pessoa pessoa : list) {
			Esporte esportePessoa = pessoa.getEsporte();
			if (esportePessoa != null) {
				Esporte esporte = esporteRepo.findById(esportePessoa.getId());
				pessoa.setEsporte(esporte);
			}
		}
	}

	public boolean insert(Pessoa pessoa) {
		return pessoas.add(pessoa);
	}
}
