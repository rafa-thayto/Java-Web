package br.com.senai.sp.informatica.mercadofamilia.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.DigestUtils;

public class Usuario {
	
	private Long id;
	private String nome;	
	private String email;
	@DateTimeFormat(pattern = "aaaa/MM/dd")
	private Date dataNascimento;
	private String senha;
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", dataNascimento=" + dataNascimento
				+ ", senha=" + senha + "]";
	}
	/**
	 * Cria um Hash para a senha do usu�rio
	 */
	public void hashPassord () {
		 try {
			 this.senha = DigestUtils.md5DigestAsHex(this.senha.getBytes());
		 } catch (Exception e) {
			 throw new RuntimeException(e);
		}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
