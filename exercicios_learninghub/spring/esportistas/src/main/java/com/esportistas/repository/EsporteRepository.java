package com.esportistas.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.esportistas.model.Esporte;

@Repository
public class EsporteRepository {

	private Set<Esporte> esportes = new HashSet<Esporte>();

	public List<Esporte> findAll() {
		return esportes.stream().toList();
	}

	public List<Esporte> findByName(String nome) {
		return esportes.stream().filter(e -> nome.equals(e.getNome().toLowerCase())).toList();
	}

	public Esporte findById(int id) {
		return esportes.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
	}

	public boolean insert(Esporte esporte) {
		return esportes.add(esporte);
	}
}
