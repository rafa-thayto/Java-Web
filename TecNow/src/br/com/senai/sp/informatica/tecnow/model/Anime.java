package br.com.senai.sp.informatica.tecnow.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Anime {

	// Props
	private Long id;
	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date registerDate;
	private User user;
	
	@Override
	public String toString() {
		return "Anime [id=" + id + ", name=" + name + ", registerDate=" + registerDate + "]";
	}
	
	// Getters and Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
