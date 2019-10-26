package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.model.RessourceHumaine;
import fr.formation.service.RessourceHumaineService;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {
	
	
	// A remettre avec config de gestion de s�curit�
	//@Autowired
	//private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RessourceHumaineService resServ;
	
	@GetMapping
	public String register() {
		return "register";
	}
	
	@PostMapping
	public String register(@ModelAttribute RessourceHumaine user) {

		String result = "redirect:./login";

		if (user.getUsername().equals("") || user.getPassword().equals("")) {
			result = "/register";
		} else {
			RessourceHumaine u = new RessourceHumaine();
			u.setUsername(user.getUsername());
			u.setPassword(user.getPassword());
			//u.setPassword(passwordEncoder.encode(user.getPassword()));
			resServ.add(u);
		}

		return result;
	}
	
}
