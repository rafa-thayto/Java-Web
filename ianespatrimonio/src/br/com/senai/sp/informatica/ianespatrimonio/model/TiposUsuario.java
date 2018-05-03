package br.com.senai.sp.informatica.ianespatrimonio.model;

public enum TiposUsuario {
	COMUM("Comum"), 
	ADMINISTRADOR("Administrador");
	
	String descricao;
	
	private TiposUsuario(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
