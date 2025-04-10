package br.com.personagens.starwars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.personagens.starwars.dto.CharacterDTO;
import br.com.personagens.starwars.service.ICharacterService;

@RestController
@RequestMapping(CharacterController.PATH)
public class CharacterController {

	private static final String PATH = "/character";

	@Autowired
	private ICharacterService service;

	@GetMapping
	public ResponseEntity<List<CharacterDTO>> findByName(@RequestParam String name) {
		return ResponseEntity.ok(service.findByName(name));
	}

}
