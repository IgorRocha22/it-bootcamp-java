package br.com.concessionaria.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.concessionaria.dto.CarDTO;
import br.com.concessionaria.model.Car;
import br.com.concessionaria.repository.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository repository;

	public CarDTO getCar(Integer id) {
		return new CarDTO(repository.getCar(id));
	}

	public List<CarDTO> getCars() {
		List<Car> cars = repository.getCars();
		return cars.stream().map(this::toCarDTOWithoutService).toList();
	}

	public List<CarDTO> getCarsByDate(LocalDate since, LocalDate to) {
		List<Car> cars = repository.getCarsByDate(since, to);
		return cars.stream().map(CarDTO::new).toList();
	}

	public List<CarDTO> getCarsByPrice(Double since, Double to) {
		List<Car> cars = repository.getCarsByPrice(since, to);
		return cars.stream().map(CarDTO::new).toList();
	}

	public CarDTO addCar(Car car) {
		repository.addCar(car);
		return new CarDTO(car);
	}

	private CarDTO toCarDTOWithoutService(Car car) {
		return new CarDTO(car.getId(), car.getBrand(), car.getModel(), car.getManifacturingDate(),
				car.getNumberOfKilometers(), car.getDoors(), car.getPrice(), car.getCurrency(), car.getCountOfOwners());
	}

}
