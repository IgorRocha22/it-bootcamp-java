package br.com.personagens.starwars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.personagens.starwars.dto.CharacterDTO;
import br.com.personagens.starwars.exception.BusinessRuleException;
import br.com.personagens.starwars.model.StarWarsCharacter;
import br.com.personagens.starwars.repository.StarWarsRepository;

@Service
public class CharacterService implements ICharacterService {

	@Autowired
	private StarWarsRepository repository;

	public List<CharacterDTO> findByName(String name) {
		validateName(name);
		name = treatName(name);
		List<StarWarsCharacter> characters = repository.findByName(name);
		return convertToDTO(characters);
	}

	private List<CharacterDTO> convertToDTO(List<StarWarsCharacter> characters) {
		return characters.stream().map(this::toCharacterDTO).toList();
	}

	private String treatName(String name) {
		return name.toLowerCase().trim();
	}

	private void validateName(String name) {
		if (name == null || name.isEmpty()) {
			throw new BusinessRuleException("Nome não informado");
		}
	}

	private CharacterDTO toCharacterDTO(StarWarsCharacter c) {
		return new CharacterDTO(c.getName(), c.getHeight(), c.getMass(), c.getGender(), c.getHomeworld(),
				c.getSpecies());
	}

}
