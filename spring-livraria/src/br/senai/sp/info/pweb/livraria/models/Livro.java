package br.senai.sp.info.pweb.livraria.models;

public class Livro {

	private Long id;
	private String nome;
	private Categoria categoria;
	
	//Getters and Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	//Constructor
	public Livro() {
		
	}
	
}
