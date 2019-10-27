package fr.formation.controller;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fr.formation.model.Salle;
import fr.formation.model.VideoProjecteur;
import fr.formation.service.VideoProjecteurService;

@Controller
public class VideoProjecteurController {
	
	@Autowired
	private VideoProjecteurService serviceVideoProjecteur;
	
	@GetMapping("/videoprojecteur")
	public String vue(Model model) {
		List<VideoProjecteur> listVideoProjecteur = serviceVideoProjecteur.findAll();
		Hibernate.initialize(listVideoProjecteur);
		model.addAttribute("listVideoProjecteur", listVideoProjecteur);
		
		return "ressourceMaterielle/videoprojecteur";
	}
	
	@GetMapping("/videoprojecteur/ajouter")
	public String ajouter() {
		return "ressourceMaterielle/formVideoProjecteur";
	}
	
	@PostMapping("/videoprojecteur/ajouter")
	public String ajouterVideoProjecteur(@ModelAttribute VideoProjecteur videoProjecteur) {
		serviceVideoProjecteur.add(videoProjecteur);		
		return "redirect:/videoprojecteur";
	}
	
	@GetMapping("/videoprojecteur/modifier/{id}")
	public String modifier(Model model, @PathVariable int id) {
		VideoProjecteur vp = serviceVideoProjecteur.getById(id);
		model.addAttribute("videoProjecteur", vp);		
		return "ressourceMaterielle/formVideoProjecteur";
	}
	
	@PostMapping("/videoprojecteur/modifier/{id}")
	public String modifierVideoProjecteur(@ModelAttribute VideoProjecteur videoProjecteur) {
		serviceVideoProjecteur.update(videoProjecteur);		
		return "redirect:/videoprojecteur";
	}
	
	@GetMapping("/videoprojecteur/supprimer/{id}")
	public String supprimer(Model model, @PathVariable int id) {
		serviceVideoProjecteur.deleteById(id);
		return "redirect:/videoprojecteur";
	}
}
