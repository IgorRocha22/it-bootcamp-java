package br.com.concessionaria.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.concessionaria.model.Car;
import br.com.concessionaria.model.Service;

public class CarDTO {

	private Integer id;
	private String brand;
	private String model;
	private LocalDate manifacturingDate;
	private int numberOfKilometers;
	private int doors;
	private double price;
	private String currency;
	private int countOfOwners;
	private List<Service> services;

	public CarDTO(Car car) {
		this.id = car.getId();
		this.brand = car.getBrand();
		this.model = car.getModel();
		this.manifacturingDate = car.getManifacturingDate();
		this.numberOfKilometers = car.getNumberOfKilometers();
		this.doors = car.getDoors();
		this.price = car.getPrice();
		this.currency = car.getCurrency();
		this.countOfOwners = car.getCountOfOwners();
		this.services = car.getServices();
	}

	public CarDTO(Integer id, String brand, String model, LocalDate manifacturingDate, int numberOfKilometers,
			int doors, double price, String currency, int countOfOwners) {
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.manifacturingDate = manifacturingDate;
		this.numberOfKilometers = numberOfKilometers;
		this.doors = doors;
		this.price = price;
		this.currency = currency;
		this.countOfOwners = countOfOwners;
		this.services = new ArrayList<Service>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public LocalDate getManifacturingDate() {
		return manifacturingDate;
	}

	public void setManifacturingDate(LocalDate manifacturingDate) {
		this.manifacturingDate = manifacturingDate;
	}

	public int getNumberOfKilometers() {
		return numberOfKilometers;
	}

	public void setNumberOfKilometers(int numberOfKilometers) {
		this.numberOfKilometers = numberOfKilometers;
	}

	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public int getCountOfOwners() {
		return countOfOwners;
	}

	public void setCountOfOwners(int countOfOwners) {
		this.countOfOwners = countOfOwners;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

}
