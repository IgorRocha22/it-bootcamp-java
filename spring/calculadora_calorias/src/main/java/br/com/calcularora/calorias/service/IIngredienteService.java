package br.com.calcularora.calorias.service;

import java.util.List;

import br.com.calcularora.calorias.model.Ingrediente;

public interface IIngredienteService {

	public List<Ingrediente> fetchIngredientes(List<Ingrediente> ingredientes);
}
