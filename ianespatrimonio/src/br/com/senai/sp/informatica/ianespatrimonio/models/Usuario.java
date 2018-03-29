package br.com.senai.sp.informatica.ianespatrimonio.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {

	@Id
	private Long id;

	@Column(length = 20, nullable = false, unique = false)
	private String nome;
	
	@Column(length = 40, nullable = false, unique = false)
	private String sobrenome;
	
	@Column(length = 120, nullable = false, unique = true)
	private String email;
	
	@Column(length = 32, nullable = false, unique = false)
	private String senha;
	
}
