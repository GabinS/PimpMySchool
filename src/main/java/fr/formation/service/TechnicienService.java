package fr.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.dao.IDAOTechnicien;
import fr.formation.model.Technicien;


@Service
public class TechnicienService {

	@Autowired
	private IDAOTechnicien daoTechnicien;
	
	public List<Technicien> findAll() {
		return daoTechnicien.findAll();
	}
	
	public Technicien get(int id) {
		return daoTechnicien.findById(id);
	}

	@Transactional
	public Technicien add(Technicien gestionnaire) {
		return daoTechnicien.save(gestionnaire);
	}
	
	@Transactional
	public Technicien edit(Technicien gestionnaire) {
		return daoTechnicien.save(gestionnaire);
	}
	
	@Transactional
	public void deleteById(int id) {
		daoTechnicien.deleteById(id);
	}
	
}
