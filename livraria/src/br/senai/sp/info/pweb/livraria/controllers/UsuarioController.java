package br.senai.sp.info.pweb.livraria.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.senai.sp.info.pweb.livraria.dao.jdbc.UsuarioDAO;
import br.senai.sp.info.pweb.livraria.models.Usuario;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@RequestMapping("usuario/novo")
	public String abrirForm() {
		
		// Abre o jsp usuario/form
		return "usuario/form";
	}
	
	@PostMapping("usuario/salvar")
	public String salvar(Usuario usuario) {
		
		System.out.println(usuario);
		usuario.hashPassword();
		usuarioDAO.persistence(usuario);
		
		return "index";
	}
	
	@GetMapping()
	public String abreLogin() {
		return "usuario/login";
	}
	
	@PostMapping("/autenticar")
	public String autenticar(Usuario usuario, HttpSession session) {
		
		usuario.hashPassword();
		
		Usuario usuarioAutenticado = usuarioDAO.auth(usuario);
		
		if(usuarioAutenticado == null) {
			System.out.println("Usuário inválido");
		}
		
		session.setAttribute("usuario", usuarioAutenticado);
		System.out.println(usuarioAutenticado);
		
		return "redirect:app/";
		
	}
	
	@GetMapping("/sair")
	public String fazerLogout(HttpSession session) {
		session.setAttribute("usuario", null);
		return "index";
	}
	
}
