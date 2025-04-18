package com.consulta.covid.model;

import java.util.HashSet;
import java.util.Set;

public class Pessoa {

	private Integer id;
	private String nome;
	private String sobrenome;
	private Integer idade;
	private Set<Sintoma> sintomas;

	public Pessoa() {
		this.sintomas = new HashSet<Sintoma>();
	}

	public Pessoa(Integer id, String nome, String sobrenome, Integer idade) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.idade = idade;
		this.sintomas = new HashSet<Sintoma>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Set<Sintoma> getSintomas() {
		return sintomas;
	}

	public void setSintomas(Set<Sintoma> sintomas) {
		this.sintomas = sintomas;
	}

	public boolean addSintoma(Sintoma sintoma) {
		return this.sintomas.add(sintoma);
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", idade=" + idade + ", sintomas="
				+ sintomas + "]";
	}

}
