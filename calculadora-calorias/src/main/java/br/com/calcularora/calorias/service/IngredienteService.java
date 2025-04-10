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
		for (String nome : ingredientesPrato.stream().map(Ingrediente::getName).toList()) {
			Ingrediente i = repository.findByName(nome.toLowerCase());
			if (i != null) {
				ingredientes.add(i);
			}
		}
		return ingredientes;
	}
}
