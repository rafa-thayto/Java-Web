package br.com.senai.sp.informatica.mercadofamilia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String abreIndex() {
		System.out.println("Me chamou");
		
		return "index";
	}

}
