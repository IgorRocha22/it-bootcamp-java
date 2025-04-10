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
			/*
			 * this.pratos = List.of(new Prato("Strogonoff", 500,
			 * buildIngredientes("Mostaza", "Ketchup", "Pollo")), new
			 * Prato("Especial do Chefe", 2500, buildIngredientes("Queso Brie",
			 * "Dátil seco", "Champiñón y otras setas", "Salchichón",
			 * "Sardina en lata con aceite vegetal")));
			 */
		}
		return this;
	}

	public void addPrato(Prato prato) {
		this.pratos.add(prato);
	}

}
