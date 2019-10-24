package fr.formation.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import fr.formation.dao.IDAOSalle;
import fr.formation.model.Salle;

public class SalleService {
	
	//@Autowired
	private IDAOSalle daoSalle;
	
	public List<Salle> getSalles() {
		return daoSalle.findAll();
	}
	
	public Salle get(int id) {
		return daoSalle.findById(id);
	}
	
	@Transactional
	public Salle add(Salle s) {
		return daoSalle.save(s);
	}
	
	@Transactional
	public void delete(int id) {
		daoSalle.deleteById(id);
	}
	
	@Transactional
	public void update(Salle s) {
		daoSalle.save(s);
	}
}
