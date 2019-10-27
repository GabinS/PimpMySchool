package fr.formation.controller;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.model.Disponibilite;
import fr.formation.model.Ordinateur;
import fr.formation.service.OrdinateurService;

@Controller
@RequestMapping(value = "/ordinateur")
public class OrdinateurController {

	@Autowired
	private OrdinateurService srvOrdinateur;
	
	//Basic page
	@GetMapping("")
	public String Ordinateur(Model model) {
		
		List<Ordinateur> listOrdinateur = srvOrdinateur.findAll();
		
		model.addAttribute("listordinateur", listOrdinateur);
		
		return "ressourceMaterielle/ordinateur";
	}
	
	//Ajout
	@GetMapping("/ajouter")
	public String add() {
		return "ressourceMaterielle/formOrdinateur";
	}
	
	@PostMapping("/ajouter")
	public String addOrdinateur(@ModelAttribute Ordinateur ordinateur) {
		srvOrdinateur.add(ordinateur);		
		return "redirect:/ordinateur";
	}
	
	//Update
	@GetMapping("/modifier/{id}")
	public String update(Model model, @PathVariable int id) {
		Ordinateur ordi = srvOrdinateur.get(id);
		model.addAttribute("ordi", ordi);		
		return "ressourceMaterielle/formOrdinateur";
	}
	
	@PostMapping("/modifier/{id}")
	public String updateOrdinateur(@ModelAttribute Ordinateur ordi) {
		srvOrdinateur.add(ordi);		
		return "redirect:/ordinateur";
	}
	
	//Delete
	@GetMapping("/supprimer/{id}")
	public String delete(Model model, @PathVariable int id) {
		srvOrdinateur.deleteById(id);
		return "redirect:/ordinateur";
	}
	
	//Reserver
	@PostMapping("/ordinateur/reserver/{id}")
	public String reserverOrdinateur(Model model, @PathVariable int id, @PathVariable Date dateDebut, @PathVariable Date dateFin, @PathVariable String libelle) {
		return "ressourceMaterielle/materiel";
	}
}
