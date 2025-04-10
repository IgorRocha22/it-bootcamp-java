package br.com.calcularora.calorias.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Ingrediente {
	@JsonAlias("name")
	private String nome;
	@JsonAlias("calories")
	private Integer calorias;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCalorias() {
		return calorias;
	}

	public void setCalorias(Integer calorias) {
		this.calorias = calorias;
	}

}
