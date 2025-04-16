package br.com.link.tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.link.tracker.dto.LinkDto;
import br.com.link.tracker.service.LinkService;

@RestController
@RequestMapping(MetricsController.PATH)
public class MetricsController {

	private static final String PATH = "/metrics";

	@Autowired
	private LinkService linkService;

	@GetMapping("/{id}")
	public ResponseEntity<LinkDto> getMetrics(@PathVariable Integer id) {
		return ResponseEntity.ok(linkService.getMetrics(id));
	}

}
