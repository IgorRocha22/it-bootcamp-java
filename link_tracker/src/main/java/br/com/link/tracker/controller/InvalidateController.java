package br.com.link.tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.link.tracker.dto.LinkDto;
import br.com.link.tracker.service.LinkService;

@RestController
@RequestMapping(InvalidateController.PATH)
public class InvalidateController {

	private static final String PATH = "/invalidate";

	@Autowired
	private LinkService linkService;

	@PostMapping("/{id}")
	public ResponseEntity<LinkDto> invalidatee(@PathVariable Integer id) {
		return ResponseEntity.ok(linkService.invalidate(id));
	}

}
