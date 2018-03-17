package br.com.senai.sp.informatica.tecnow.dao;

import java.util.List;

public interface DAO<T> {

	public T search(Long id);
	public List<T> searchAll();
	public void insert(T obj);
	public void remove(T obj);
	public void change(T obj);
	
}
