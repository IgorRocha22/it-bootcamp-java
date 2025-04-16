package br.com.link.tracker.repository;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import br.com.link.tracker.entity.Link;

@Repository
public class LinkRepository {

	private HashMap<Integer, Link> links;

	public LinkRepository() {
		links = new HashMap<Integer, Link>();
	}

	public Link createLink(Link link) {
		Integer newId = links.size() + 1;
		link.setId(newId);
		link.setCountRedirect(0);
		links.put(newId, link);
		return link;
	}

	public Link findById(Integer id) {
		return links.get(id);
	}

	public boolean exists(Integer id) {
		return links.containsKey(id);
	}

	public void invalidateLink(Integer id) {
		Link link = links.get(id);
		link.setValid(false);
	}
}
