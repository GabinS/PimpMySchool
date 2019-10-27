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
import fr.formation.service.FormateurService;
import fr.formation.service.MatiereService;
import fr.formation.service.UniteEnseignementService;

@Controller
@RequestMapping(value = "/formation/matiere")
public class MatiereController {
	
	@Autowired
	private MatiereService srvMatiere;
	
	@Autowired
	private UniteEnseignementService srvUniteEnseignementService;
	
	@Autowired
	private FormateurService srvFormateur;

	private String list = "listMatiere";
	private String form = "matiereForm";
	
	@GetMapping("")
	public String Matiere(Model model) {
		model.addAttribute("listmatiere", srvMatiere.findAll());
		
		model.addAttribute("title", "Matière");
		model.addAttribute("list", this.list);
		model.addAttribute("form", "descriptionMatiere");
		return "formation/formationTemplate";
	}
	
	@GetMapping("/add")
	public String CreateMatiereGet(Model model) {
		model.addAttribute("listmatiere", srvMatiere.findAll());
		model.addAttribute("listFormateur", srvFormateur.findAll());
		model.addAttribute("listUE", srvUniteEnseignementService.findAll());
		
		model.addAttribute("title", "Nouvelle matière");
		model.addAttribute("list", this.list);
		model.addAttribute("form", this.form);
		return "formation/formationTemplate";
	}
	
	@GetMapping("/edit/{id}")
	public String EditMatiereGet(Model model, @PathVariable int id) {
		Matiere matiere = srvMatiere.get(id);
		if (matiere != null) {
			model.addAttribute("matiere", matiere);
			
			model.addAttribute("listmatiere", srvMatiere.findAll());
			model.addAttribute("listFormateur", srvFormateur.findAll());
			model.addAttribute("listUE", srvUniteEnseignementService.findAll());

			// pb de récupération (censé récupérer la liste des unités d'enseignement de la matière)
			//model.addAttribute("listUE_matiere", matiere.getListUniteEnseignement());
					
			model.addAttribute("title", "Edition de la matière " + matiere.getTitre());		
			model.addAttribute("list", this.list);
			model.addAttribute("form", this.form);
			return "formation/formationTemplate";
		}
		return "redirect:/formation/matiere";		
	}
	
	@GetMapping("/delete/{id}")
	public String DeleteMatiereGet(Model model, @PathVariable int id) {
		srvMatiere.deleteById(id);
		return "redirect:/formation/matiere";
	}
	
	@PostMapping("/add")
	public String CreateMatierePost(@ModelAttribute Matiere matiere) {
		srvMatiere.add(matiere);
		return "redirect:/formation/matiere";
	}
	
	@PostMapping("/edit/{id}")
	public String EditMatierePost(Model model, @ModelAttribute Matiere matiere) {
		srvMatiere.edit(matiere);
		return "redirect:/formation/matiere";
	}
}
