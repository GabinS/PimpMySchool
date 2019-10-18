package fr.formation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.formation.models.Formation;

@Controller
public class FormationController {

	@GetMapping("formation")
	public String FormationGet(Model model) {
		
		Formation f = new Formation();
		f.setLibelle("Master II");
		
		model.addAttribute("formation", f);
		return "formation";
	}
}
