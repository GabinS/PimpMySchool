package fr.formation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("")
	public String HomeGet(Model model) {
		model.addAttribute("title", "Home");
		return "home";
	}
	
}
