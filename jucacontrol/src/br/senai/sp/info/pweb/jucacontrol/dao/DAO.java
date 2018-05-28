package br.senai.sp.info.pweb.jucacontrol.dao;

import br.senai.sp.info.pweb.jucacontrol.models.CategoriaOcorrencia;

import java.util.List;

public interface DAO<T> {
	
	public void persistir(T obj);
	
	public CategoriaOcorrencia alterar(T obj);
	
	public CategoriaOcorrencia deletar(T obj);
	
	public T buscar(Long id);
	
	public List<T> buscarTodos();

}
