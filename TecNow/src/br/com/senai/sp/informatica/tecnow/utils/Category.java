package br.com.senai.sp.informatica.tecnow.utils;

public enum Category {
	TIRO("Tiro"), 
	RPG("RPG"), 
	PLATAFORMA("Plataforma"), 
	ESPORTE("Esporte"), 
	HACK_AND_SLASH("Hack and Slash"), 
	OUTRO("Outro");
	
	private String description;
	
	Category(String category) {
		this.description = category;
	}
	
	public String getDescription() {
		return description;
	}

}
