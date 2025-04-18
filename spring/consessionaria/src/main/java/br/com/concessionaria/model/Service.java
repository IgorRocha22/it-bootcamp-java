package br.com.concessionaria.model;

import java.time.LocalDate;

public class Service {
	private LocalDate date;
	private Integer kilometers;
	private String descriptions;

	public Service(LocalDate date, Integer kilometers, String descriptions) {
		this.date = date;
		this.kilometers = kilometers;
		this.descriptions = descriptions;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Integer getKilometers() {
		return kilometers;
	}

	public void setKilometers(Integer kilometers) {
		this.kilometers = kilometers;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

}
