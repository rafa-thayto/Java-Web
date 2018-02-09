package br.senai.sp.informatica.model;

public class Game {
	
	private Long id;
	private String name;
	private String dev;
	
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


	public String getDev() {
		return dev;
	}


	public void setDev(String dev) {
		this.dev = dev;
	}


	public Game(Long id, String name, String dev) {
		super();
		this.id = id;
		this.name = name;
		this.dev = dev;
	}
	
	public Game() {
		
	}


	@Override
	public String toString() {
		return "Game [name=" + name + ", dev=" + dev + "]";
	}
	
}
