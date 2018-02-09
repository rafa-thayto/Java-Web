package br.senai.sp.info.pweb.livraria.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Determina que a classe é um controller do Spring
public class IndexController {

	// Todo método de Controller que retorna um view
	// deve retornar um String
	@RequestMapping("/")
	public String abrirIndex() {
		System.out.println("Me chamou");
		
		// Faz um forward para o index
		return "index";
	}
	
	@RequestMapping("index2")
	public String abrirOutraPage() {
		
		return "outro-index";
	}
	
}
