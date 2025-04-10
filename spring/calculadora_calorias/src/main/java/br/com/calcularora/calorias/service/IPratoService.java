package br.com.calcularora.calorias.service;

import java.util.List;

import br.com.calcularora.calorias.dto.PratoDTO;

public interface IPratoService {

	public PratoDTO inserePrato(PratoDTO dto);

	public List<PratoDTO> inserePratos(List<PratoDTO> dtos);
}
