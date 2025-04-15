package br.com.link.tracker.entity;

public class Link {

	private Integer id;
	private String location;
	private Integer countRedirect;
	private boolean valid;
	private String password;

	public Link(Integer id, String location, Integer countRedirect, boolean valid, String password) {
		this.id = id;
		this.location = location;
		this.countRedirect = countRedirect;
		this.valid = valid;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getCountRedirect() {
		return countRedirect;
	}

	public void setCountRedirect(Integer countRedirect) {
		this.countRedirect = countRedirect;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void incrementCountRedirect() {
		this.countRedirect += 1;
	}
}
