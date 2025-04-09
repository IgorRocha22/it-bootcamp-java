package com.esportistas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.esportistas.dto.EsporteDTO;
import com.esportistas.dto.PessoaDTO;
import com.esportistas.model.Esporte;
import com.esportistas.model.Pessoa;
import com.esportistas.repository.EsporteRepository;
import com.esportistas.repository.PessoaRepository;

@RestController
public class EsporteController {

	@Autowired
	private EsporteRepository repository;
	@Autowired
	private PessoaRepository pessoaRepo;

	@GetMapping("/findSports")
	public ResponseEntity<List<EsporteDTO>> findAll() {
		mock();
		List<Esporte> esportes = repository.findAll();
		List<EsporteDTO> responseDto = converteDto(esportes);
		return ResponseEntity.ok(responseDto);
	}

	@GetMapping("/findSport/{name}")
	public ResponseEntity<List<EsporteDTO>> findByName(@PathVariable String name) {
		mock();
		if (name == null || name.isEmpty()) {
			return ResponseEntity.badRequest().build();
		}
		List<Esporte> esportes = repository.findByName(name.toLowerCase());
		List<EsporteDTO> responseDto = converteDto(esportes);
		return ResponseEntity.ok(responseDto);
	}

	@GetMapping("/findSportsPersons")
	public ResponseEntity<List<PessoaDTO>> findSportsPersons() {
		mock();
		List<Pessoa> pessoas = pessoaRepo.findAll();
		List<PessoaDTO> dto = converteDtoPessoa(pessoas);
		return ResponseEntity.ok(dto);

	}

	private List<PessoaDTO> converteDtoPessoa(List<Pessoa> pessoas) {
		List<PessoaDTO> responseDto = new ArrayList<PessoaDTO>();
		for (Pessoa pessoa : pessoas) {
			responseDto.add(new PessoaDTO(pessoa.getNome(), pessoa.getSobrenome(), pessoa.getEsporte().getNome()));
		}
		return responseDto;
	}

	private List<EsporteDTO> converteDto(List<Esporte> esportes) {
		List<EsporteDTO> responseDto = new ArrayList<EsporteDTO>();
		for (Esporte esporte : esportes) {
			responseDto.add(new EsporteDTO(esporte.getNome(), esporte.getNivel()));
		}
		return responseDto;
	}
	
	private void mock() {
		repository.insert(new Esporte(1, "Futebol", "Avancado"));
		repository.insert(new Esporte(2, "Voleibol", "Avancado"));
		repository.insert(new Esporte(3, "Futebol", "Iniciante"));
		repository.insert(new Esporte(4, "Handbol", "Intermediario"));
		repository.insert(new Esporte(5, "Jiu-Jitsu", "Iniciante"));

		pessoaRepo.insert(new Pessoa("Igor", "Rocha", 21, new Esporte(1)));
		pessoaRepo.insert(new Pessoa("Joao", "da Silva", 40, new Esporte(5)));
	}

}
