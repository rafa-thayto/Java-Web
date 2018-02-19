package br.senai.sp.info.pweb.livraria.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.DigestUtils;

public class Usuario {
	
	private Long id;
	
	private String nome;
	
	private String sobrenome;
	
	// Determina para o Spring como converter a data
	// no momento de injetar o objeto
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataNascimento;
	
	private String email;
	
	private String senha;

	public void hashPassword() {
		try {
			this.senha = DigestUtils.md5DigestAsHex(this.senha.getBytes("UTF-8"));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", dataNascimento="
				+ dataNascimento + ", email=" + email + ", senha=" + senha + "]";
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
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
