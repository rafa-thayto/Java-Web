package br.com.senai.sp.informatica.mercadofamilia.dao;

import java.util.List;

public interface DAO<T> {
	
	public T buscar(Long id);
	
	public List<T> buscarTodos();
	
	public void inserir(T obj);
	
	public void deletar(T obj);
	
	public void alterar(T obj);
	
}
