package br.com.concessionaria.model;

import java.time.LocalDate;
import java.util.List;

public class Car {
	private Integer id;
	private String brand;
	private String model;
	private LocalDate manifacturingDate;
	private int numberOfKilometers;
	private int doors;
	private double price;
	private String currency;
	private List<Service> services;
	private int countOfOwners;

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

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public void addService(Service service) {
		this.services.add(service);
	}

	public int getCountOfOwners() {
		return countOfOwners;
	}

	public void setCountOfOwners(int countOfOwners) {
		this.countOfOwners = countOfOwners;
	}

}
