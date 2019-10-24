package fr.formation.dao;

import java.util.List;

public interface IDAO <T>{
	public T findById(int id);
	public List<T> findAll();
	public T save(T obj);
	public void deleteById(int id);
}
