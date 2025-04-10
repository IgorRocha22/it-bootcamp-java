package br.com.calcularora.calorias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.calcularora.calorias.dto.PratoDTO;
import br.com.calcularora.calorias.service.IPratoService;

@RestController
@RequestMapping("/prato")
public class PratoController {
	@Autowired
	private IPratoService service;

	@PostMapping
	public ResponseEntity<PratoDTO> inserePrato(@RequestBody PratoDTO prato) {
		return ResponseEntity.ok(service.inserePrato(prato));
	}
}
