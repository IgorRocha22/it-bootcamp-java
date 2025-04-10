package com.consulta.covid.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consulta.covid.dto.PessoaDTO;
import com.consulta.covid.model.Pessoa;
import com.consulta.covid.model.Sintoma;
import com.consulta.covid.service.PessoaService;

@RestController
@RequestMapping("/person")
public class PessoaController {
	@Autowired
	private PessoaService service;

	@GetMapping("/findRiskPerson")
	public ResponseEntity<List<PessoaDTO>> findRiskPerson() {
		List<Pessoa> pessoas = service.findByRiskGroup();
		List<PessoaDTO> dto = new ArrayList<PessoaDTO>();
		for (Pessoa pessoa : pessoas) {
			List<String> sintomas = pessoa.getSintomas().stream().map(Sintoma::getNome).toList();
			StringBuilder builder = new StringBuilder();
			sintomas.stream().forEach(s -> builder.append(" | " + s));
			dto.add(new PessoaDTO(pessoa.getNome(), pessoa.getSobrenome(), builder.toString()));
		}
		return ResponseEntity.ok(dto);
	}

	@PostMapping
	public ResponseEntity<?> insert(@RequestBody Pessoa pessoa) {
		if (!service.insert(pessoa)) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.created(URI.create("/person")).build();
	}
}
