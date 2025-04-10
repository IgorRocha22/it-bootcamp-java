package br.com.calcularora.calorias.service;

import java.util.List;
import java.util.Optional;

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
		repository.addPrato(prato);
		int totalCalorias = prato.getIngredientes().stream().mapToInt(Ingrediente::getCalorias).sum();
		Optional<Ingrediente> ingredienteMaiorCaloria = prato.getIngredientes().stream()
				.sorted((o1, o2) -> o2.getCalorias() - o1.getCalorias()).findFirst();
		return new PratoDTO(prato.getNome(), prato.getPeso(), prato.getIngredientes(), totalCalorias,
				ingredienteMaiorCaloria.get());
	}

}
