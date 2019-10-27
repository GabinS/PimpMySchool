package fr.formation.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.dao.IDAOPlanning;
import fr.formation.model.Planning;

@Service
public class PlanningService {
	
	@Autowired
	private IDAOPlanning daoPlanning;
	
	public PlanningService() {
		
	}
	
	public Planning get(int id) {
		return daoPlanning.findById(id);
	}
	
	public List<Planning> getListePlannings(){
		return daoPlanning.findAll();
	}


	@Transactional
	public void add(Planning p) {
		daoPlanning.save(p);
		
	}

	@Transactional
	public void update(Planning p) {
		daoPlanning.save(p);		
		System.out.println(p.getDateDebut());
	}
	
	@Transactional
	public void delete(int id) {
		daoPlanning.deleteById(id);
	}

}