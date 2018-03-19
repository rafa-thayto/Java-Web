package br.com.senai.sp.informatica.tecnow.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.senai.sp.informatica.tecnow.model.User;

@Controller
@RequestMapping("/user")
public class UserController {

	// Signup
	@GetMapping("/signup")
	public String openSignup() {
		return "user/signup";
	}
	@PostMapping("/signup")
	public User registeringUser(User user) {
		return null;
	}
	
	// Login
	@GetMapping("/login")
	public String openLogin() {
		return "user/login";
	}
	
	@PostMapping("/auth")
	public String auth(User user, Model model) {
		
		// Store errors
		List<String> errors = new ArrayList<>(10);
		
		if (user.getEmail() == null ||
			user.getEmail().length() < 5 ||
			user.getEmail().length() > 120) {
			errors.add("O email é obrigatório e deve conter de 5 a 120 caracteres!");
		}
		if (user.getPassword() == null) {
			errors.add("A senha é obrigatória!");
		}
		if (!errors.isEmpty()) {
			System.out.println("Erros: " + errors);
			model.addAttribute("errors", errors);
			return "usuario/login";
		}
		// End
		
		return "redirect:app/";
	}
	
}
