package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.model.Matiere;
import fr.formation.service.MatiereService;

@Controller
@RequestMapping(value = "/formation/matiere")
public class MatiereController {
	
	@Autowired
	private MatiereService srvMatiere;
	
	@GetMapping("")
	public String Matiere(Model model) {
		//model.addAttribute("listmatiere", srvMatiere.findAll());
		
		model.addAttribute("title", "Matière");
		return "formation/matiereForm";
	}
	
	@GetMapping("/add")
	public String CreateMatiereGet(Model model) {
		model.addAttribute("title", "Nouvelle matière");
		return "formation/matiereForm";
	}
	
	@GetMapping("/edit/{id}")
	public String EditMatiereGet(Model model, @PathVariable int id) {
		//Matiere matiere = srvMatiere.get(id);
		model.addAttribute("title", "Edition de la matière " + "titre"); //matiere.getTitre()
		model.addAttribute("id", id);
		return "formation/matiereForm";
	}
	
	@GetMapping("/delete/{id}")
	public String DeleteMatiereGet(Model model, @PathVariable int id) {
		srvMatiere.deleteById(id);
		return "redirect:/formation/matiere";
	}
	
	@PostMapping("/create")
	public String CreateMatierePost(@ModelAttribute Matiere matiere) {
		srvMatiere.add(matiere);
		return "redirect:/formation/matiere";
	}
	
	@PostMapping("/delete/{id}")
	public String DeleteMatierePost(@PathVariable int id) {
		//TODO save edition
		return "redirect:/formation/matiere";
	}
	
}
