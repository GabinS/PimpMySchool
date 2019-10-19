package fr.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.model.Matiere;
import fr.formation.service.MatiereService;

@Controller
@RequestMapping(value = "/matiere")
public class MatiereController {
	
	@Autowired
	private MatiereService srvMatiere;
	
	@GetMapping("")
	public String Matiere(Model model) {
		model.addAttribute("title", "Nouvelle matière");
		return "redirect:/matiere/create";
	}
	
	@GetMapping("/create")
	public String CreateMatiere(Model model) {
		model.addAttribute("title", "Nouvelle matière");
		return "formation/matiereForm";
	}
	
	@GetMapping("/edit/{id}")
	public String EditMatiere(Model model, @PathVariable int id) {
		Matiere matiere = srvMatiere.get(id);
		model.addAttribute("title", "Edition de la matière " + matiere.getTitre());
		return "formation/matiereForm";
	}
	
	@PostMapping("/inscription")
	public String subscribe() {
		return "redirect:/formation";
	}
}
