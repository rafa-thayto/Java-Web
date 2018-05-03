package br.com.senai.sp.informatica.ianespatrimonio.dao;

import java.util.List;

public interface DAO<T> {
	
	public void persistir(T obj);
	public void deletar(T obj);
	public void alterar(T obj);
	public void buscarId(Long id);
	public List<T> buscarTodos();
	
}
