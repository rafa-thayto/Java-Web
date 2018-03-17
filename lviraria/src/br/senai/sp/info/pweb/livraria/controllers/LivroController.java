package br.senai.sp.info.pweb.livraria.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class LivroController {

	@GetMapping(value = { "", "/" })
	public String abrePaginaDeLivros() {
		return "livro/lista";
	}
}
