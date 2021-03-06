package br.senai.sp.info.pweb.livraria.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.senai.sp.info.pweb.livraria.dao.jdbc.UsuarioDAO;
import br.senai.sp.info.pweb.livraria.models.Usuario;
import br.senai.sp.info.pweb.livraria.util.SessionUtils;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioDAO usuarioDAO;
	// Injeto o SessionUtils atrav�s de @Autowired
	@Autowired
	private SessionUtils sessionUtils;
	
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
	
	@GetMapping("/usuario/login")
	public String abreLogin() {
		return "usuario/login";
	}
	
	@PostMapping("/autenticar")
<<<<<<< HEAD
	public String autenticar(Usuario usuario, HttpSession session, Model model) {
		
		List<String> erros = new ArrayList<>(10);
		
		if (usuario.getEmail() == null || usuario.getEmail().length() < 5 || usuario.getEmail().length() > 120) {
			erros.add("O email � obrigat�rio e deve conter de 2 a 120 caracteres");
		}
		
		if (usuario.getSenha() == null || usuario.getSenha().length() < 8 || usuario.getSenha().length() > 130) {
			erros.add("A senha � obrigat�ria e deve conter de 5 a 30 caracteres");
		}
		
		if (erros.isEmpty()) {
			model.addAttribute("erros", erros);
		}
=======
	public String autenticar(Usuario usuario) {
>>>>>>> df367a87626c70343e73f2e9e6aab5938957542d
		
		usuario.hashPassword();
		
		Usuario usuarioAutenticado = usuarioDAO.auth(usuario);
		
		if(usuarioAutenticado == null) {
			System.out.println("Usu�rio inv�lido");
		}
		sessionUtils.setUsuarioLogado(usuarioAutenticado);
		System.out.println(usuarioAutenticado);
		
		return "redirect:app/";
		
	}
	
	@GetMapping("/sair")
	public String fazerLogout(HttpSession session) {
//		session.setAttribute("usuario", null);
		sessionUtils.matarSessao();
		return "redirect:/";
	}
	
}
