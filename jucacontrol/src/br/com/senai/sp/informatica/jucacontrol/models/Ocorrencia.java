package br.com.senai.sp.informatica.jucacontrol.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Ocorrencia {
	
	@Id
	private Long id;
	
	@Column(length = 30, nullable = false, unique = false)
	private String titulo;
	
	@Column(nullable = false, unique = false)
	@Lob // Determina que o campo n�o tem limite estipulado pelo length
	private String descricao;
	
	@Column(nullable = false, unique = false)
	private Date dataCadastro;
	
	@Column(nullable = false, unique = false)
	private Date dataModificacao;
	
	@Column(nullable = true, unique = false)
	private Date dataConclusao;
	
	@ManyToOne
	private CategoriaOcorrencia categoriaOcorrencia;
	
	@ManyToOne
	private Usuario tecnico; // quem atendeu
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(Date dataModificacao) {
		this.dataModificacao = dataModificacao;
	}

	public Date getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(Date dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	public CategoriaOcorrencia getCategoriaOcorrencia() {
		return categoriaOcorrencia;
	}

	public void setCategoriaOcorrencia(CategoriaOcorrencia categoriaOcorrencia) {
		this.categoriaOcorrencia = categoriaOcorrencia;
	}

	public Usuario getTecnico() {
		return tecnico;
	}

	public void setTecnico(Usuario tecnico) {
		this.tecnico = tecnico;
	}

	public Usuario getEmissor() {
		return emissor;
	}

	public void setEmissor(Usuario emissor) {
		this.emissor = emissor;
	}

	@ManyToOne
	private Usuario emissor; // quem abriu
	
}
