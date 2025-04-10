package br.com.personagens.starwars.service;

import java.util.List;

import br.com.personagens.starwars.dto.CharacterDTO;

public interface ICharacterService {

	public List<CharacterDTO> findByName(String name);
}
