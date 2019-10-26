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
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.dao.IDAOSalle;
import fr.formation.model.Salle;
import fr.formation.service.SalleService;

@Controller
public class SalleController {
	@Autowired
	private SalleService serviceSalle;
	
	@Autowired
	private IDAOSalle daoSalle;
	
	@GetMapping("/salle")
	public String vue(Model model) {
		List<Salle> listSalle = serviceSalle.getSalles();
		Hibernate.initialize(listSalle);
		model.addAttribute("listSalle", listSalle);
		
		return "ressourceMaterielle/salle";
	}
	
	@GetMapping("/salle/ajouter")
	public String ajouter() {
		return "ressourceMaterielle/ajouterSalle";
	}
	
	@PostMapping("/salle/ajouter")
	public String ajouterSalle(@RequestParam int cout, @RequestParam int nbPlaces, @RequestParam String adresseP, @RequestParam String contactA) {
		//Salle s = new Salle();
		//s.setCout(cout);
		//s.setNbMaxUser(nbPlaces);
		//s.setAdresse(adresseP);
		//s.setContactAdministratif(contactA);
		//daoSalle.save(s);
		
		return "redirect:/salle";
	}
	
	@GetMapping("/salle/reserver/{id}")
	public String reserver(@PathVariable int id) {
		return "ressourceMaterielle/reserverSalle";
	}
	
	@PostMapping("/salle/reserver/{id}")
	public String reserverSalle(@PathVariable int id) {
		
		return "redirect:/salle";
	}
}
