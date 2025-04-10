package br.com.calcularora.calorias.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.calcularora.calorias.model.Ingrediente;

@Repository
public class IngredienteRepository {
	private IngredienteRepository repository;
	private List<Ingrediente> ingredientes;

	public IngredienteRepository() {
		this.repository = getInstance();
	}

	private IngredienteRepository getInstance() {
		if (repository == null) {
			this.ingredientes = fetchIngredientes();
		}
		return this;
	}

	private List<Ingrediente> fetchIngredientes() {
		ObjectMapper objectMapper = new ObjectMapper();
		List<Ingrediente> ingredientesJson = new ArrayList<Ingrediente>();
		ingredientesJson = readJsonFile(objectMapper, ingredientesJson);
		return ingredientesJson;
	}

	public Ingrediente findByName(String name) {
		return ingredientes.stream().filter(c -> c.getNome().toLowerCase().contains(name)).findFirst().orElse(null);
	}

	private List<Ingrediente> readJsonFile(ObjectMapper objectMapper, List<Ingrediente> ingredientesJson) {
		try {
			ingredientesJson = objectMapper.readValue(new File("src/main/resources/static/ingredientes.json"),
					new TypeReference<List<Ingrediente>>() {
					});
		} catch (IOException e) {
			throw new RuntimeException("Erro inesperado durante a leitura do arquivo json\n" + e.getMessage());
		}
		return ingredientesJson;
	}

}
