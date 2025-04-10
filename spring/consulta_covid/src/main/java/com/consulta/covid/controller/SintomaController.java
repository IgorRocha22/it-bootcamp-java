package com.consulta.covid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.consulta.covid.model.Sintoma;
import com.consulta.covid.service.SintomaService;

@RestController
public class SintomaController {
	@Autowired
	private SintomaService service;

	@GetMapping("/findSymptom")
	public ResponseEntity<List<Sintoma>> findSymptons() {
		List<Sintoma> sintomas = service.findAll();
		return ResponseEntity.ok(sintomas);
	}
	
	@GetMapping("/findSymptom/{name}")
	public ResponseEntity<List<Sintoma>> findSymptonsByName(@PathVariable String name) {
		List<Sintoma> sintomas = service.findByName(name);
		return ResponseEntity.ok(sintomas);
	}

	@PostMapping("/symptom")
	public ResponseEntity<Sintoma> insertSymptom(@RequestBody Sintoma sintoma) {
		if (!service.insertSymptom(sintoma)) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(sintoma);
	}
}
