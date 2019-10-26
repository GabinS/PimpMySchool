package fr.formation.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.dao.IDAOSalle;
import fr.formation.model.Salle;
import fr.formation.service.SalleService;

@Controller
public class SalleController {
	
	@Autowired
	private SalleService serviceSalle;
	
	@GetMapping("/salle")
	public String vue(Model model) {
		List<Salle> listSalle = serviceSalle.getSalles();
		Hibernate.initialize(listSalle);
		model.addAttribute("listSalle", listSalle);
		
		return "ressourceMaterielle/salle";
	}
	
	@GetMapping("/salle/ajouter")
	public String ajouter() {
		return "ressourceMaterielle/formSalle";
	}
	
	@PostMapping("/salle/ajouter")
	public String ajouterSalle(@ModelAttribute Salle salle) {
		serviceSalle.add(salle);		
		return "redirect:/salle";
	}
	
	@GetMapping("/salle/modifier/{id}")
	public String modifier(Model model, @PathVariable int id) {
		Salle s = serviceSalle.get(id);
		model.addAttribute("salle", s);		
		return "ressourceMaterielle/formSalle";
	}
	
	@PostMapping("/salle/modifier/{id}")
	public String modifierSalle(@ModelAttribute Salle salle) {
		serviceSalle.add(salle);		
		return "redirect:/salle";
	}
	
	@GetMapping("/salle/supprimer/{id}")
	public String supprimer(Model model, @PathVariable int id) {
		serviceSalle.delete(id);
		return "redirect:/salle";
	}
	
	@GetMapping("/salle/reserver/{id}")
	public String reserver(Model model, @PathVariable int id) {
		Salle s = serviceSalle.get(id);
		model.addAttribute("salle", s);		
		return "ressourceMaterielle/reserverSalle";
	}
	
	@PostMapping("/salle/reserver/{id}")
	public String reserverSalle(@PathVariable int id) {
		
		//TODO
		
		return "redirect:/salle";
	}
}
