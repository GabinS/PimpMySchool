package fr.formation.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fr.formation.dao.IDAOSalle;
import fr.formation.model.Salle;
import fr.formation.service.SalleService;

@Controller
public class SalleController {
	@Autowired
	private IDAOSalle daoSalle;
	
	@Autowired
	private SalleService serviceSalle;
	
	//TODO : Modifier le mapping ?
	@GetMapping("/salle/ajouter")
	public String add() {
		return "addSalle";
	}
	
	//TODO : Modifier le mapping ?
	@PostMapping("/salle/{id}")
	public String view(@PathVariable int id, Model model) {
		List<Salle> listSalle = serviceSalle.getSalles();
		Hibernate.initialize(listSalle);
		model.addAttribute("listSalle", listSalle);
		
		return "salle";
	}
}
