package br.com.calcularora.calorias.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.calcularora.calorias.model.Prato;

@Repository
public class PratoRepository {
	private PratoRepository repository;
	private List<Prato> pratos;

	public PratoRepository() {
		this.repository = getInstance();
	}

	private PratoRepository getInstance() {
		if (repository == null) {
			this.pratos = new ArrayList<Prato>();
		}
		return this;
	}

	public void inserePrato(Prato prato) {
		this.pratos.add(prato);
	}

}
