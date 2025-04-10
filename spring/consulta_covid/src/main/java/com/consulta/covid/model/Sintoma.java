package com.consulta.covid.model;

import java.util.Objects;

import com.consulta.covid.constantes.NivelGravidadeEnum;

public class Sintoma {

	private Integer codigo;
	private String nome;
	private NivelGravidadeEnum nivelGravidade;

	public Sintoma() {
	}

	public Sintoma(Integer codigo, String nome, NivelGravidadeEnum nivelGravidade) {
		this.codigo = codigo;
		this.nome = nome;
		this.nivelGravidade = nivelGravidade;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelGravidadeEnum getNivelGravidade() {
		return nivelGravidade;
	}

	public void setNivel_gravidade(NivelGravidadeEnum nivelGravidade) {
		this.nivelGravidade = nivelGravidade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sintoma other = (Sintoma) obj;
		return Objects.equals(codigo, other.codigo);
	}

}
