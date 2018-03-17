package br.senai.sp.info.pweb.livraria.dao;

import java.util.List;

public interface DAO<T> {
	
	public T buscar(Long id);
	
	public List<T> buscarTodos();
	
	public void alterar(T obj);
	
	public void deletar(T obj);
	
	public void persistir(T obj);

}
