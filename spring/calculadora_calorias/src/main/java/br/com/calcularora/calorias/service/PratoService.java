package br.com.calcularora.calorias.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.calcularora.calorias.dto.PratoDTO;
import br.com.calcularora.calorias.model.Ingrediente;
import br.com.calcularora.calorias.model.Prato;
import br.com.calcularora.calorias.repository.PratoRepository;

@Service
public class PratoService implements IPratoService {
	@Autowired
	private PratoRepository repository;
	@Autowired
	private IIngredienteService ingredienteService;

	@Override
	public PratoDTO inserePrato(PratoDTO dto) {
		List<Ingrediente> ingredientes = ingredienteService.fetchIngredientes(dto.getIngredientes());
		Prato prato = new Prato(dto.getNome(), dto.getPeso(), ingredientes);
		repository.inserePrato(prato);
		return constroiDto(prato);
	}

	@Override
	public List<PratoDTO> inserePratos(List<PratoDTO> dtos) {
		return dtos.stream().map(this::inserePrato).toList();
	}

	private PratoDTO constroiDto(Prato prato) {
		PratoDTO responseDto = new PratoDTO(prato.getNome(), prato.getPeso(), prato.getIngredientes());
		realizaCalculosIngrediente(prato, responseDto);
		return responseDto;
	}

	private void realizaCalculosIngrediente(Prato prato, PratoDTO responseDto) {
		Integer totalCalorias = ingredienteService.calculaTotalCalorias(prato.getIngredientes());
		Ingrediente ingredienteMaiorCaloria = ingredienteService
				.recuperaIngredienteMaiorCaloria(prato.getIngredientes());
		responseDto.setTotalCalorias(totalCalorias);
		responseDto.setIngredienteMaiorCaloria(ingredienteMaiorCaloria);
	}

}
