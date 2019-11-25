package fr.formation.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.dao.IDAODisponibilite;
import fr.formation.model.Disponibilite;

@Service
public class DisponibiliteService {
	
	@Autowired
	private IDAODisponibilite daoDisponibilite;
	
	public List<Disponibilite> findAll() {
		return daoDisponibilite.findAll();
	}
	
	public Disponibilite get(int id) {
		return daoDisponibilite.findById(id);
	}
	
	@Transactional
	public Disponibilite add(Disponibilite d) {
		return daoDisponibilite.save(d);
	}
	
	@Transactional
	public void delete(int id) {
		daoDisponibilite.deleteById(id);
	}
	
	@Transactional
	public void update(Disponibilite d) {
		daoDisponibilite.save(d);
	}
}