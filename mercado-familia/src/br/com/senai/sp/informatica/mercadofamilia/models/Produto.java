package br.com.senai.sp.informatica.mercadofamilia.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Produto {

	private Long id;
	private String nome;
	@DateTimeFormat(pattern = "aaaa/MM/dd")
	private Date dataCadastro;
	private Double preco;
	
	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", dataCadastro=" + dataCadastro + ", preco=" + preco + "]";
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
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
}
