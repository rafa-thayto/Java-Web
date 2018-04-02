package br.com.senai.sp.informatica.ianespatrimonio.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.util.DigestUtils;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 20, nullable = false, unique = false)
	private String nome;
	
	@Column(length = 40, nullable = false, unique = false)
	private String sobrenome;
	
	@Column(length = 120, nullable = false, unique = true)
	private String email;
	
	@Column(length = 32, nullable = false, unique = false)
	private String senha;

	public void hashearSenha() {
		this.senha = DigestUtils.md5DigestAsHex(this.senha.getBytes());
	}
	
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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
