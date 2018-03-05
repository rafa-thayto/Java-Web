package br.com.senai.sp.informatica.mercadofamilia.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.senai.sp.informatica.mercadofamilia.dao.UsuarioDAO;
import br.com.senai.sp.informatica.mercadofamilia.models.Usuario;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO usuarioDAO;

	
	/*
	 * Request para a p�gina
	 */
	@GetMapping("/usuario/cadastro")
	public String abreCadastro() {
		return "usuario/cadastro";
	}
	
	/*
	 * Cadastro do usu�rio
	 */
	@PostMapping("/usuario/salvar")
	public String salvar (Usuario usuario) {
		return "index";
	}
	
	/*
	 * Fazendo login do usu�rio
	 */
	@GetMapping("/usuario/login")
	public String abreLogin() {
		return "usuario/login";
	}
	
	@PostMapping("/autenticar")
	public String autenticar () {
		return "redirect:app/";
	}
	
	@PostMapping("/sair")
	public String sair (HttpSession httpSession) {
		httpSession.invalidate();
		return "redirect:/";
	}
	
}
