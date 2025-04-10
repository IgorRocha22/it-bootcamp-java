package br.com.calcularora.calorias.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.calcularora.calorias.model.Ingrediente;
import br.com.calcularora.calorias.repository.IngredienteRepository;

@Service
public class IngredienteService implements IIngredienteService {

	@Autowired
	private IngredienteRepository repository;

	public List<Ingrediente> fetchIngredientes(List<Ingrediente> ingredientesPrato) {
		List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
		for (String nome : ingredientesPrato.stream().map(Ingrediente::getNome).toList()) {
			Ingrediente i = repository.findByName(nome.toLowerCase());
			if (i != null) {
				ingredientes.add(i);
			}
		}
		return ingredientes;
	}

	public Integer calculaTotalCalorias(List<Ingrediente> ingredientes) {
		return ingredientes.stream().mapToInt(Ingrediente::getCalorias).sum();
	}

	public Ingrediente recuperaIngredienteMaiorCaloria(List<Ingrediente> ingredientes) {
		return ingredientes.stream().sorted((o1, o2) -> o2.getCalorias() - o1.getCalorias()).findFirst().orElse(null);
	}
}
