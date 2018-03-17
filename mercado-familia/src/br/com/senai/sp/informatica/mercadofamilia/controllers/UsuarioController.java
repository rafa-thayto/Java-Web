package br.com.senai.sp.informatica.mercadofamilia.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.senai.sp.informatica.mercadofamilia.dao.UsuarioDAO;
import br.com.senai.sp.informatica.mercadofamilia.models.Usuario;
import br.com.senai.sp.informatica.mercadofamilia.utils.SessionUtils;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	@Autowired
	private SessionUtils sessionUtils;
	
	/*
	 * Request para a página
	 */
	@GetMapping("/usuario/cadastro")
	public String abreCadastro() {
		return "usuario/cadastro";
	}
	
	/*
	 * Cadastro do usuário
	 */
	@PostMapping("/usuario/salvar")
	public String salvar (Usuario usuario) {
		return "index";
	}
	
	/*
	 * Fazendo login do usuário
	 */
	@GetMapping("/usuario/login")
	public String abreLogin() {
		return "usuario/login";
	}
	
	@PostMapping("/autenticar")
	public String autenticar (Usuario usuario) {
		
		usuario.hashPassord();
		
		sessionUtils.setUsuarioLogado(usuario);;
		
		return "redirect:app/";
	}
	
	@PostMapping("/sair")
	public String sair () {
		sessionUtils.killSession();
		return "redirect:/";
	}
	
}
