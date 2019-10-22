package fr.formation.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import fr.formation.dao.IDAOSalle;
import fr.formation.model.Salle;

public class SalleService {
	@Autowired
	private IDAOSalle daoSalle;
	
	public List<Salle> getSalles() {
		return daoSalle.FindAll();
	}
	
	public Salle get(int id) {
		return daoSalle.FindById(id);
	}
	
	@Transactional
	public Salle add(Salle s) {
		return daoSalle.Save(s);
	}
	
	@Transactional
	public void delete(int id) {
		daoSalle.DeleteById(id);
	}
	
	@Transactional
	public void update(Salle s) {
		daoSalle.Save(s);
	}
}
