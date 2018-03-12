package br.com.senai.sp.informatica.tecnow.utils;

public enum Gender {
	MASCULINO("Masculino"), 
	FEMININO("Feminino");
	
	private String description;
	
	// How use
	//	Category cat = Category.ESPORTE;
	//	model.addAttribute("categories", Category.values());
	//	getCategory().getDescricao()
	//	${category.descricao}
	
	Gender(String gender) {
		this.description = gender;
	}

	public String getDescription() {
		return description;
	}
	
}
