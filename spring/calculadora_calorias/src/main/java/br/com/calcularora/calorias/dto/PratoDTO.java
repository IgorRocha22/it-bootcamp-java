package br.com.calcularora.calorias.dto;

import java.util.List;

import br.com.calcularora.calorias.model.Ingrediente;

public class PratoDTO {
	private String nome;
	private Integer peso;
	private List<Ingrediente> ingredientes;
	private Integer totalCalorias;
	private Ingrediente ingredienteMaiorCaloria;

	public PratoDTO() {
	}

	public PratoDTO(String nome, Integer peso, List<Ingrediente> ingredientes) {
		this.nome = nome;
		this.peso = peso;
		this.ingredientes = ingredientes;
	}

	public PratoDTO(String nome, Integer peso, List<Ingrediente> ingredientes, Integer totalCalorias,
			Ingrediente ingredienteMaiorCaloria) {
		this.nome = nome;
		this.peso = peso;
		this.ingredientes = ingredientes;
		this.totalCalorias = totalCalorias;
		this.ingredienteMaiorCaloria = ingredienteMaiorCaloria;
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

	public Integer getTotalCalorias() {
		return totalCalorias;
	}

	public void setTotalCalorias(Integer totalCalorias) {
		this.totalCalorias = totalCalorias;
	}

	public Ingrediente getIngredienteMaiorCaloria() {
		return ingredienteMaiorCaloria;
	}

	public void setIngredienteMaiorCaloria(Ingrediente ingredienteMaiorCaloria) {
		this.ingredienteMaiorCaloria = ingredienteMaiorCaloria;
	}

}
