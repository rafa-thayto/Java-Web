package br.com.senai.sp.informatica.rh.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cargo {

	@Id
	private Long id;
	
	@Column(length = 30, nullable = false, unique = true)
	private String nome;
	
	@Column(nullable = false, unique = false, precision = 10, scale= 2)
	private Double salario;

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

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	// TUTORIAL DO FELIPE: COmo o hibernate trata campos num�ricos
	// Se for...
	// Long, ent�o ser� BIGINT
	// Integer, ent�o ser� INT
	// Double ou FLoat, ent�o ser� NUMERIC (com precis�o e escalas diferentes)
	// precision = Quantidade de casas de n�meros inteiros
	// scale = Quantidade de caas de n�meros decimais
	
}
