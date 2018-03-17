package br.senai.sp.info.pweb.livraria.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //determina que a classe é um controller do spring
public class indexController {
	
	//Todo o método de controller que retorna uma view
	//deve retornar uma String
	
	@RequestMapping("/")
	public String abrirIndex() {
		System.out.println("Me chamou (abrirIndex)");
		
		//faz um foward para o index
		return "Index";
	}
	
	@RequestMapping("/ovo")
	public String abrirSurpresa() {
		return "vcdestriuomeuovo";
	}
	
	
	
	

}
