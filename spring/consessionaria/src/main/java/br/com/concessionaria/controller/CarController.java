package br.com.concessionaria.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.concessionaria.dto.CarDTO;
import br.com.concessionaria.model.Car;
import br.com.concessionaria.service.CarService;

@RestController
@RequestMapping("/v1/api/vehicles")
public class CarController {

	@Autowired
	private CarService service;

	@GetMapping("/{id}")
	public ResponseEntity<CarDTO> getCars(@PathVariable Integer id) {
		return ResponseEntity.ok(service.getCar(id));
	}

	@GetMapping("/search/dates")
	public ResponseEntity<List<CarDTO>> getCarsByDate(@RequestParam LocalDate since, @RequestParam LocalDate to) {
		return ResponseEntity.ok(service.getCarsByDate(since, to));
	}

	@GetMapping("/search/prices")
	public ResponseEntity<List<CarDTO>> getCarsByPrice(@RequestParam Double since, @RequestParam Double to) {
		return ResponseEntity.ok(service.getCarsByPrice(since, to));
	}

	@GetMapping
	public ResponseEntity<List<CarDTO>> getCars() {
		return ResponseEntity.ok(service.getCars());
	}

	@PostMapping
	public ResponseEntity<CarDTO> addCar(@RequestBody Car car) {
		return ResponseEntity.ok(service.addCar(car));
	}

}
