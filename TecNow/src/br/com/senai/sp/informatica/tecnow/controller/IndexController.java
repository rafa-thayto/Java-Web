package br.com.senai.sp.informatica.tecnow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String openIndex() {
		return "index";
	}
	
	@RequestMapping("/app/home") 
	public String appHome() {
		return "home";
	}
	
}
