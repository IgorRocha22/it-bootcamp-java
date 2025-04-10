package br.com.concessionaria.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.concessionaria.model.Car;

@Repository
public class CarRepository {

	private CarRepository repository;

	private List<Car> cars;

	public CarRepository() {
		repository = getInstance();
	}

	private CarRepository getInstance() {
		if (repository == null) {
			this.cars = new ArrayList<Car>();
		}
		return this;
	}

	public void addCar(Car car) {
		int id = this.cars.size() + 1;
		car.setId(id);
		this.cars.add(car);
	}

	public List<Car> getCars() {
		return this.cars.stream().toList();
	}

	public Car getCar(Integer id) {
		return this.cars.stream().filter(c -> id.equals(c.getId())).findFirst().orElse(null);
	}

	public List<Car> getCarsByDate(LocalDate since, LocalDate to) {
		return this.cars.stream()
				.filter(c -> c.getManifacturingDate().isAfter(since) && c.getManifacturingDate().isBefore(to)).toList();
	}

	public List<Car> getCarsByPrice(Double since, Double to) {
		return this.cars.stream().filter(c -> c.getPrice() > since && c.getPrice() < to).toList();
	}
}
