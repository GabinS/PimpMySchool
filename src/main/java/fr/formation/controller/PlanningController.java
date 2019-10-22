package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.model.Planning;
import fr.formation.service.PlanningService;

@Controller
@RequestMapping(value = "/planning")
public class PlanningController {
	
	@Autowired
	private PlanningService srvPlanning;
	
	@GetMapping("/liste")
	public String findAll(Model model) {
		model.addAttribute("plannings", srvPlanning.getListePlannings());
		
		return "listePlannings";
	}
	
	@PostMapping("/add")
	public String addPlanning(@ModelAttribute Planning p) {
		srvPlanning.add(p);
		
		return "redirect:./liste";
	}

	@PostMapping("/edit")
	public String editPlanning(@ModelAttribute Planning p, @RequestParam int id) {
		srvPlanning.update(p);
		return "redirect:./liste";
	}

	@GetMapping("/delete/{id}")
	public String deletePlanning(Model model, @PathVariable int id) {
		srvPlanning.delete(id);
		return "redirect:/planning";
	}
}