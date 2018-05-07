package br.com.senai.sp.informatica.ianespatrimonio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	/**
	 * Open the index page
	 * @return
	 */
	@GetMapping(value = {"/", ""})
	public String abrirLogin() {
		return "index";
	}
	
}
