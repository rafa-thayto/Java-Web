package br.senai.sp.info.pweb.livraria.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.DigestUtils;

public class Usuario {
	
	private Long id;
	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date dataNascimento;
	
	//Criptografar Senha
	public void hashearSenha() {
		
		try {
			
			this.senha = DigestUtils.md5DigestAsHex(this.senha.getBytes("UTF-8"));
			
		} catch (Exception e) {

			throw new RuntimeException(e);
			
		}
		
	}
	
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
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	//Constructor
	public Usuario() {
		
	}
	
	//To String
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email + ", senha="
				+ senha + ", dataNascimento=" + dataNascimento + "]";
	}
	
	
	
}
