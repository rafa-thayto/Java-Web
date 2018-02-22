package br.com.senai.sp.informatica.mercadofamilia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.senai.sp.informatica.mercadofamilia.dao.UsuarioDAO;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO usuarioDAO;

	@PostMapping("/usuario/login")
	public String abreLogin() {
		return "usuario/login";
	}
	
	@PostMapping("/usuario/cadastro")
	public String abreCadastro() {
		return"usuario/cadastro";
	}
	
}
