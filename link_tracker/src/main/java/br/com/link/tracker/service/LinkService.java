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
		encodePassword(dto);
		return ConvertLinkUtil.toDto(repository.createLink(entity));
	}

	private void encodePassword(LinkDto dto) {
		if (dto.password() != null && !dto.password().isEmpty()) {
			Base64.getEncoder().encode(dto.password().getBytes());
		}
	}

	private void validate(LinkDto dto, Link entity) {
		if (dto.location() == null || dto.location().isEmpty()) {
			throw new BusinessException("URL do link não informado");
		}
		if (!isValidURI(dto.location())) {
			throw new BusinessException("URL inválida");
		}
		entity.setValid(true);
	}

	public LinkDto redirect(Integer id, String password) {
		Link link = repository.findById(id);
		validateRedirect(id, password, link);
		return ConvertLinkUtil.toDto(link);
	}

	private void validateRedirect(Integer id, String password, Link link) {
		if (link == null) {
			throw new NotFoundException("Link com ID " + id + " não localizado");
		}
		if (link.getPassword() != null) {
			if (password == null || password.isEmpty()) {
				throw new BusinessException("Senha não informada");
			}
			byte[] passwordDecoded = Base64.getDecoder().decode(link.getPassword());
			if (passwordDecoded != password.getBytes()) {
				throw new BusinessException("Senha incorreta!");
			}
		}
	}

	public static boolean isValidURI(String uriString) {
		try {
			URI uri = new URI(uriString);
			return uri.getScheme() != null && uri.getHost() != null;
		} catch (URISyntaxException e) {
			return false; // If there's a syntax error, return false
		}
	}
}
