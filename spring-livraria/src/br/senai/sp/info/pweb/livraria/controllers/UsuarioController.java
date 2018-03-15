package br.senai.sp.info.pweb.livraria.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.senai.sp.info.pweb.livraria.dao.jdbc.UsuarioDao;
import br.senai.sp.info.pweb.livraria.models.Usuario;
import br.senai.sp.info.pweb.livraria.utils.SessionUtils;

@Controller
public class UsuarioController {
	
	//UsuarioDao usuarioDao = new UsuarioDao();
	@Autowired
	private UsuarioDao usuarioDao;
	
	@Autowired
	private SessionUtils sessionUtils;
	
	@GetMapping("/entrar")
	public String abreLogin() {
		
		return "Usuario/login";
		
	}
	
	@GetMapping("/sair")
	public String fazerLogout(HttpSession session) {
		
		sessionUtils.UnsetUsuarioLogado();
		
		return "index";
		
	}
	
	//Model envia dados para a View
	@PostMapping("/autenticar")
	public String autenticar(Usuario usuario, Model model) {
		
		// Lista de erros
		List<String> erros = new ArrayList<>(6);
		
		// Valida��es
		if(usuario.getEmail() == null) {
			
			erros.add("O campo e-mail � obrigat�rio");
			
		} else if(usuario.getEmail().length() < 1 || usuario.getEmail().length() > 120) {
			
			erros.add("O campo e-mail deve conter entre 1 e 120 caract�res");
			
		}
		
		if(usuario.getSenha() == null) {
			
			erros.add("O campo senha � obrigat�rio");
			
		} else if(usuario.getSenha().length() < 1 || usuario.getSenha().length() > 20) {
			
			erros.add("O campo senha deve conter entre 1 e 20 caract�res");
			
		}
		
		// Verifica se a lista est� vazia (sem erros) ou n�o (com erros)
		//Se houver erros, retorne a p�gina com a(s) mensagem(s) de erro(s)
		if(!erros.isEmpty()) {
			
			model.addAttribute("erros", erros);
			return "Usuario/login";
			
		}
		
		// Autentica��o
		usuario.hashearSenha();
		
		Usuario usuarioAutenticado = usuarioDao.autenticar(usuario);
		
		if(usuarioAutenticado == null) {
			
			System.out.println("Usu�rio Inv�lido");
			
		}
		
		//Aplica o usu�rio na sess�o
		sessionUtils.setUsuarioLogado(usuarioAutenticado);
		
		System.out.println("Filtrado" + usuarioAutenticado);
		
		return "Cadastro/form";
		
	}
	
	@GetMapping("/usuario/novo")
	public String abreForm() {
		
		return "Usuario/form";
		
	}
	
	@PostMapping("/usuario/salvar")
	public String salvar(Usuario usuario) {
		
		usuario.hashearSenha();
		usuarioDao.persistir(usuario);
		
		System.out.println(usuario);
		
		return "index";
		
	}
	
}
