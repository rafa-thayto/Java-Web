package br.com.senai.sp.informatica.ianespatrimonio.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Patrimonio {

	@Id
	private Long id;
	
	@Column(length = 30, nullable = false, unique = false)
	private String nome;
	
	@Column()
	private Date data_movimentacao;

	public Patrimonio(Long id, String nome, Date data_movimentacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.data_movimentacao = data_movimentacao;
	}
	
}
