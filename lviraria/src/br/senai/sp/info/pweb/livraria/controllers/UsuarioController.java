package br.senai.sp.info.pweb.livraria.controllers;

import java.util.ArrayList;
import java.util.LinkedList;
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
	
	//UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	//Injeta o SessionUtils através de @Autowired
	@Autowired
	private SessionUtils sessionUtils;
	
	
	
	
	@RequestMapping("/usuario/novo")
	public String abrirForm() {
		return "usuario/form";
	}
	
	
	@PostMapping("/usuario/salvar")
	public String salvar(Usuario u) {
		
		
		u.criptografarSenha();
		
		System.out.println("Cadastrado: " + u);
		
		usuarioDAO.persistir(u);
		
		return"Index";
	}
	
	
	@GetMapping("entrar")
	public String abreLogin() {
		return "usuario/login";
	}
	
	@PostMapping("/autenticar")
	public String autenticar(Usuario usuario, Model model) {
		
		//Guarda os possiveis erros
		List<String> erros = new ArrayList<>(10);
		
		if (usuario.getEmail() == null || 
			usuario.getEmail().length() < 2 ||
			usuario.getEmail().length() > 120) {
			erros.add("O email é obrigatório e deve conter de 2 a 120 caracteres");
		}
		
		if (usuario.getSenha() == null || 
				usuario.getSenha().length() < 5 ||
				usuario.getSenha().length() > 30) {
				erros.add("A senha é obrigatório e deve conter de 5 a 30 caracteres");
			}
		//verufucar se akusta de erris bçai esta vazia
		//se não estiver, encia os erros na requisição e abre a pagina de login
		System.out.println("Erros: " + erros);
		if (!erros.isEmpty()) {
			model.addAttribute("erros", erros);
			return "usuario/login";
		}
		
		usuario.criptografarSenha();
		
		System.out.println("Recebido: " + usuario);
		Usuario usuarioAutenticado = usuarioDAO.autenticar(usuario);
		System.out.println("Buscado: " + usuarioAutenticado);
		
		if (usuarioAutenticado == null) {
			System.out.println("UsuarioInvalido");
			return "usuario/login";
		}
		
		System.out.println(usuarioAutenticado);
		
//		session.setAttribute("usuario", usuarioAutenticado);
		sessionUtils.setUsuarioLogado(usuarioAutenticado
				);
		
		return"redirect:app/";
	}
	
	@GetMapping("/sair")
	public String fazerLogout() {
		
		sessionUtils.matarSessao();
		
		return "redirect:/";
	}
	
}
