package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import fr.formation.model.Planning;
import fr.formation.service.FormationService;
import fr.formation.service.MatiereService;
import fr.formation.service.PlanningService;
import fr.formation.service.SalleService;

@Controller
@RequestMapping(value = "/planning")
public class PlanningController {
	
	@Autowired
	private PlanningService srvPlanning;
	
	@Autowired
	private MatiereService srvMatiere;
	
	@Autowired
	private FormationService srvFormation;

	@Autowired
	private SalleService srvSalle;
	
	private String list= "listPlanning";
	private String form= "planningForm";
	private String view = "planningView";
	
	
	@GetMapping("")
	public String Planning(Model model) {
		//model.addAttribute("listPlanning", srvPlanning.getListePlannings());
		model.addAttribute("title", "Planning");
		model.addAttribute("list", this.list);
		model.addAttribute("form", "descriptionPlanning");
		return "planning/planningTemplate";
	}
	
	@GetMapping("/listea")
	public String findAll(Model model) {
	//	model.addAttribute("plannings", srvPlanning.getListePlannings());
		model.addAttribute("title", "Planning");
		model.addAttribute("list", view);
		model.addAttribute("form", view);
		return "planning/listPlanning";
	}
	
	@GetMapping("/vue")
	public String vuePlanning(Model model) {
	//	model.addAttribute("plannings", srvPlanning.getListePlannings());
		model.addAttribute("title", "Planning du XXX au XXX");
		return "planning/planningView";
	}
		
	@GetMapping("/add")
	public String createPlanningGet(Model model) {
		//model.addAttribute("listPlanning", srvPlanning.getListePlannings());
		
		model.addAttribute("title", "Nouveau cours");
		model.addAttribute("matieres", srvMatiere.findAll());
		model.addAttribute("formations", srvFormation.findAll());
		model.addAttribute("salles", srvSalle.getSalles());
		model.addAttribute("list", this.list);
		model.addAttribute("form", this.form);
		return "planning/planningTemplate";
	}

	@PostMapping("/add")
	public String createPlanningPost(@ModelAttribute Planning p) {
		srvPlanning.add(p);		
		return "redirect:/planning";
	}

	@GetMapping("/edit/{id}")
	public String editPlanningGet(Model model, @PathVariable int id) {
		Planning planning = srvPlanning.get(id);
		model.addAttribute("planning", planning);
		
	//	model.addAttribute("listPlanning", srvPlanning.getListePlannings());
		
		model.addAttribute("title", "Edition du cours " + planning.getMatiere());		
		model.addAttribute("list", this.list);
		model.addAttribute("form", this.form);
		return "planning/planningTemplate";
	}
	
	@PostMapping("/edit")
	public String editPlanningPost(@ModelAttribute Planning p) {
		srvPlanning.update(p);
		return "redirect:./liste";
	}

	@GetMapping("/delete/{id}")
	public String deletePlanningGet(Model model, @PathVariable int id) {
		srvPlanning.delete(id);
		return "redirect:/planning";
	}
}