package com.esportistas.model;

import java.util.Objects;

public class Esporte {
	private int id;
	private String nome;
	private String nivel;

	public Esporte() {
	}

	public Esporte(int id) {
		this.id = id;
	}

	public Esporte(int id, String nome, String nivel) {
		this.id = id;
		this.nome = nome;
		this.nivel = nivel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nivel, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Esporte other = (Esporte) obj;
		return id == other.id;
	}

}
