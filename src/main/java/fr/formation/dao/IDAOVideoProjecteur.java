package fr.formation.dao;

import java.util.List;

public interface IDAOVideoProjecteur <T>{
	public T FindById(int id);
	public List<T> FindAll();
	public T Save(T t);
	public void DeleteById(int id);
}
