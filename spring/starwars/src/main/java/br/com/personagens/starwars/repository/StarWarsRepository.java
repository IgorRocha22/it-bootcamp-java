package br.com.personagens.starwars.repository;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.personagens.starwars.model.StarWarsCharacter;

@Repository
public class StarWarsRepository {
	private StarWarsRepository repository;
	private List<StarWarsCharacter> starWarsCharacters;

	public StarWarsRepository() {
		this.repository = getInstance();
	}

	private StarWarsRepository getInstance() {
		if (repository == null) {
			this.starWarsCharacters = readJsonFile();
		}
		return this;
	}

	private List<StarWarsCharacter> readJsonFile() {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.readValue(new File("src/main/resources/static/starwars.json"),
					new TypeReference<List<StarWarsCharacter>>() {
					});
		} catch (IOException e) {
			throw new RuntimeException("Erro inesperado durante a leitura do arquivo json\n" + e.getMessage());
		}
	}

	public List<StarWarsCharacter> findByName(String name) {
		return starWarsCharacters.stream().filter(c -> c.getName().toLowerCase().contains(name)).toList();
	}
}
