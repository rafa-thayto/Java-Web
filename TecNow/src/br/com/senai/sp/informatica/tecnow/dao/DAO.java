package br.com.senai.sp.informatica.tecnow.dao;

import java.util.List;

public interface DAO<T> {

	public T search(Long id);
	public List<T> searchAll();
	public T add(T obj);
	public T remove(T obj);
	public T change(T obj);
	
}