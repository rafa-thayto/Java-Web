package br.com.senai.sp.informatica.tecnow.dao;

import java.util.List;

public interface DAO<T> {

	/**
	 * This method searches something specific in DB
	 * @param id
	 * @return
	 */
	public T search(Long id);
	/**
	 * This method searches all something in DB
	 * @return ArrayList
	 */
	public List<T> searchAll();
	/**
	 * This method searches all something specific in DB
	 * @param obj
	 * @return ArrayList
	 */
	public List<T> searchAllBy(T obj);
	/**
	 * This method insert something in the DB
	 * @param obj
	 */
	public void insert(T obj);
	/**
	 * This method removes something in the DB 
	 * @param obj
	 */
	public void remove(T obj);
	/**
	 * This method changes something in the DB
	 * @param obj
	 */
	public void change(T obj);
	
}
