package fr.formation.dao;

import java.util.List;

public interface IDAO <T>{
	public T FindById(int id);
	public List<T> FindAll();
	public T Save(T obj);
	public void DeleteById(int id);
}
