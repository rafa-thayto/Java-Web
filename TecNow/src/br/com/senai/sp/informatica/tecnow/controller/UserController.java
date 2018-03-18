package br.com.senai.sp.informatica.tecnow.controller;

import org.springframework.stereotype.Controller;
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
	public String auth(User user) {
		return "redirect:app/";
	}
	
}
