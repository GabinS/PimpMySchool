package fr.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.dao.IDAOFormateur;
import fr.formation.model.Formateur;

@Service
public class FormateurService {

	@Autowired(required = false)
	private IDAOFormateur daoFormateur;
	
	public List<Formateur> findAll() {
		return daoFormateur.findAll();
	}
	
	public Formateur get(int id) {
		return daoFormateur.findById(id);
	}

	@Transactional
	public Formateur add(Formateur formateur) {
		return daoFormateur.save(formateur);
	}
	
	@Transactional
	public void deleteById(int id) {
		daoFormateur.deleteById(id);
	}
	
}
