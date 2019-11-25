package fr.formation.controller;

import java.util.ArrayList;
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
import fr.formation.service.DisponibiliteService;
import fr.formation.service.OrdinateurService;

@Controller
@RequestMapping(value = "/ordinateur")
public class OrdinateurController {

	@Autowired
	private OrdinateurService srvOrdinateur;

	@Autowired
	private DisponibiliteService srvDispo;
	
	//Basic page
	@GetMapping("")
	public String Ordinateur(Model model) {
		
		List<Ordinateur> listOrdinateur = srvOrdinateur.findAll();
		
		model.addAttribute("listordinateur", listOrdinateur);
		
		for (Ordinateur ordinateur : listOrdinateur) {
			
			try {
				
				List<Disponibilite> listDispo = ordinateur.getListDisponibilite();
				
				for (Disponibilite disponibilite : listDispo) {
					
					model.addAttribute("dispo", disponibilite);
					
				}
				
			} catch (Exception e) {
				
				model.addAttribute("error", e);
				
			}
			
			
		}
		
		
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
		
		Ordinateur ordi = srvOrdinateur.get(id);
		List<Disponibilite> listDispo = ordi.getListDisponibilite();
		
		for (int i = 0; i < listDispo.size(); i++) {
			Disponibilite dispo = listDispo.get(i);
			srvDispo.delete(dispo.getId());
		}
		
		ordi.setListDisponibilite(new ArrayList<Disponibilite>());
		
		srvOrdinateur.save(ordi);
		srvOrdinateur.deleteById(id);
		return "redirect:/ordinateur";
	}		
}
