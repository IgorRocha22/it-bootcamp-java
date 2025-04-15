package br.com.link.tracker.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.link.tracker.dto.LinkDto;
import br.com.link.tracker.entity.Link;
import br.com.link.tracker.exception.BusinessException;
import br.com.link.tracker.exception.NotFoundException;
import br.com.link.tracker.repository.LinkRepository;
import br.com.link.tracker.utils.ConvertLinkUtil;

@Service
public class LinkService {

	@Autowired
	private LinkRepository repository;

	public LinkDto createLink(LinkDto dto) {
		Link entity = ConvertLinkUtil.toEntity(dto);
		validate(dto, entity);
		encodePassword(dto, entity);
		return ConvertLinkUtil.toDto(repository.createLink(entity));
	}

	private void encodePassword(LinkDto dto, Link entity) {
		if (dto.password() != null && !dto.password().isEmpty()) {
			String passwordEncoded = Base64.getEncoder().encodeToString(dto.password().getBytes());
			entity.setPassword(passwordEncoded);
		}
	}

	private void validate(LinkDto dto, Link entity) {
		if (dto.location() == null || dto.location().isEmpty()) {
			throw new BusinessException("URL do link não informado");
		}
		if (!isValidURI(dto.location())) {
			throw new BusinessException("URL inválida");
		}
		if (dto.password() != null && dto.password().length() < 2) {
			throw new BusinessException("Senha precisa ter ao menos 2 dígitos");
		}
		entity.setValid(true);
	}

	public LinkDto redirect(Integer id, String password) {
		Link link = repository.findById(id);
		validateRedirect(id, password, link);
		link.incrementCountRedirect();
		return ConvertLinkUtil.toDto(link);
	}

	private void validateRedirect(Integer id, String password, Link link) {
		if (link == null) {
			throw new NotFoundException("Link com ID " + id + " não localizado");
		}
		if (!link.isValid()) {
			throw new BusinessException("O link informado não está válido para acesso");
		}
		if (link.getPassword() != null) {
			if (password == null || password.isEmpty()) {
				throw new BusinessException("Senha não informada");
			}
			String passwordEncoded = Base64.getEncoder().encodeToString(password.getBytes());
			if (!link.getPassword().equals(passwordEncoded)) {
				throw new BusinessException("Senha incorreta!");
			}
		}
	}

	public static boolean isValidURI(String uriString) {
		try {
			URI uri = new URI(uriString);
			return uri.getScheme() != null && uri.getHost() != null;
		} catch (URISyntaxException e) {
			return false;
		}
	}

	public LinkDto getMetrics(Integer id) {
		Link link = repository.findById(id);
		if (link == null) {
			throw new NotFoundException("Link não localizado com o id " + id);
		}
		return ConvertLinkUtil.toDto(link);
	}

	public LinkDto invalidate(Integer id) {
		Link link = repository.findById(id);
		if (link == null) {
			throw new NotFoundException("Link não localizado com o id " + id);
		}
		link.setValid(false);
		return ConvertLinkUtil.toDto(link);
	}
}
