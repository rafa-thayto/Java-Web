package br.senai.sp.info.pweb.livraria.dao;

import java.util.List;

public interface DAO<T> {

	public T search(Long id);
	public List<T> searchAll();
	public void change(T obj);
	public void delete(T obj);
	public void persistence(T obj);
	
}
