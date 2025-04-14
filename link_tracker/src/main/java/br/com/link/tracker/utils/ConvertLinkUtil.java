package br.com.link.tracker.utils;

import br.com.link.tracker.dto.LinkDto;
import br.com.link.tracker.entity.Link;

public class ConvertLinkUtil {

	public static Link toEntity(LinkDto dto) {
		return new Link(dto.id(), dto.location(), dto.countRedirect(), dto.valid(), dto.password());
	}

	public static LinkDto toDto(Link entity) {
		return new LinkDto(entity.getId(), entity.getLocation(), entity.getCountRedirect(), entity.isValid(),
				entity.getPassword());
	}
}
