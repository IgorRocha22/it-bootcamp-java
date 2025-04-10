package com.consulta.covid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consulta.covid.model.Pessoa;
import com.consulta.covid.model.Sintoma;
import com.consulta.covid.model.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;
	@Autowired
	private SintomaService sintomaService;

	public List<Pessoa> findByRiskGroup() {
		return repository.findByRiskGroup();
	}

	public boolean insert(Pessoa pessoa) {
		valida(pessoa);
		fetchSintomas(pessoa);
		return repository.insert(pessoa);
	}

	private void valida(Pessoa pessoa) {
		if (pessoa == null) {
			throw new RuntimeException("Pessoa não enviada");
		}
		if (pessoa.getId() == null) {
			throw new RuntimeException("Id não informado");
		}
		if (pessoa.getNome() == null || pessoa.getNome().isEmpty()) {
			throw new RuntimeException("Nome não informado");
		}
		if (pessoa.getIdade() == null || pessoa.getIdade() < 0) {
			throw new RuntimeException("Idade inválida");
		}
	}

	private void fetchSintomas(Pessoa pessoa) {
		for (Sintoma sintoma : pessoa.getSintomas()) {
			validaSintoma(sintoma);
			sintoma = sintomaService.findById(sintoma.getCodigo());
		}
	}

	private void validaSintoma(Sintoma sintoma) {
		if (sintoma.getCodigo() == null) {
			throw new RuntimeException("Código não informado");
		}
	}
}
