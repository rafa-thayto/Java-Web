package br.senai.sp.info.pweb.jucacontrol.dao;

import java.util.List;

public interface DAO<T> {
	
	public List<T> buscarTodos();
	
	public T buscar(Long id);
	
	public void persistir(T obj);
	
	public void alterar(T obj);
	
	public void deletar(T obj);

}
