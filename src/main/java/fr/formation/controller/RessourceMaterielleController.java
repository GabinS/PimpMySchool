package fr.formation.controller;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.formation.model.Ordinateur;
import fr.formation.model.Salle;
import fr.formation.model.VideoProjecteur;
import fr.formation.service.OrdinateurService;
import fr.formation.service.SalleService;
import fr.formation.service.VideoProjecteurService;

@Controller
public class RessourceMaterielleController {

	@Autowired
	private OrdinateurService srvOrdinateur;
	
	@Autowired
	private SalleService srvSalle;
	
	@Autowired
	private VideoProjecteurService srvVideoProj;
	
	@GetMapping("/materiel")
	public String Materiel(Model model) {
		
		List<Ordinateur> listOrdinateur = srvOrdinateur.findAll();
		List<Salle> listSalle = srvSalle.getSalles();
		//List<VideoProjecteur> listVideoProjecteurs = srvVideoProj.findAll();
		
		Hibernate.initialize(listOrdinateur);
		Hibernate.initialize(listSalle);
		//Hibernate.initialize(listVideoProjecteurs);
		
		model.addAttribute("listordinateur", listOrdinateur);
		model.addAttribute("listsalle", listOrdinateur);
		model.addAttribute("listvideoproj", listOrdinateur);
		
		return "ressourceMaterielle/materiel";
	}
}
