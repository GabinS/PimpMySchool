package fr.formation.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.dao.IDAOOrdinateur;
import fr.formation.model.Ordinateur;

@Service
public class OrdinateurService {

	@Autowired(required = false)
	private IDAOOrdinateur daoOrdinateur;
	
	@Transactional
	public List<Ordinateur> findAll() {
		return daoOrdinateur.findAll();
	}
	
	public Ordinateur get(int id) {
		return daoOrdinateur.findById(id);
	}
	
	@Transactional
	public Ordinateur save(Ordinateur ordi) {
		return daoOrdinateur.save(ordi);
	}
	
	@Transactional
	public Ordinateur add(Ordinateur ordi) {
		return daoOrdinateur.save(ordi);
	}
	
	@Transactional
	public Ordinateur edit(Ordinateur ordi) {
		return daoOrdinateur.save(ordi);
	}
	
	@Transactional
	public void deleteById(int id) {
		daoOrdinateur.deleteById(id);
	}

}
