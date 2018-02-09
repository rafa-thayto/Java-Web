package br.senai.sp.model;

import java.io.Serializable;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String usuario;

	private String senha;
	
	public Usuario() {
		
	}

	public Usuario(Long id, String usuario, String senha) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
