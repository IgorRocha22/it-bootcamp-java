package br.com.calcularora.calorias.model;

import java.util.List;

public class Prato {
	private String nome;
	private Integer peso;
	private List<Ingrediente> ingredientes;

	public Prato(String nome, Integer peso, List<Ingrediente> ingredientes) {
		super();
		this.nome = nome;
		this.peso = peso;
		this.ingredientes = ingredientes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

}
