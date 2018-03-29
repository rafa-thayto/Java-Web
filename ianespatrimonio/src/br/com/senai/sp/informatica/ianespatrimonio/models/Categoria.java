package br.com.senai.sp.informatica.ianespatrimonio.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Categoria {

	@Id
	private Long id;
	
	@Column(length = 30, nullable = false, unique = true)
	private String nome;
	
}
