package br.com.link.tracker.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.link.tracker.dto.LinkDto;
import br.com.link.tracker.service.LinkService;

@RestController
@RequestMapping(LinkController.PATH)
public class LinkController {

	private static final String PATH = "/link";
	private static final String PATH_ID = "/{id}";

	@Autowired
	private LinkService service;

	@GetMapping(PATH_ID)
	public ResponseEntity<LinkDto> redirect(@PathVariable Integer id, @RequestParam(required = false) String password) {
		LinkDto dto = service.redirect(id, password);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(URI.create(dto.location()));
		return new ResponseEntity<LinkDto>(dto, headers, HttpStatus.SEE_OTHER);
	}

	@PostMapping
	public ResponseEntity<LinkDto> createLink(@RequestBody LinkDto dto) {
		return ResponseEntity.ok(service.createLink(dto));
	}
}
