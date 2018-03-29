package br.com.senai.sp.informatica.rh.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
// @Table(name = "tb_functionario") mudando o nome da tabela
public class Funcionario {

	@Id
	private Long id;
	
	@Column(length = 30, nullable = false, unique = false)
	private String nome;
	
	@OneToOne
	@JoinColumn(name = "endereco_id", nullable = false)
	private Endereco endereco;
	
	@ManyToMany
	@JoinTable(
			name =  "alocacoes",
			joinColumns = @JoinColumn(name = "funcionario_id"), // Chave estrangeira desta entidade (FUNCIONARIO)
			inverseJoinColumns = @JoinColumn(name = "setor_id")
	) // Usa essa annotation quando for definir parametros para relacoes many to many
	private List<Setor> setor;
	
	@ManyToOne
	@JoinColumn(name = "cargo_id", nullable = false)
	private Cargo cargo;
	
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Setor> getSetor() {
		return setor;
	}

	public void setSetor(List<Setor> setor) {
		this.setor = setor;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
}
