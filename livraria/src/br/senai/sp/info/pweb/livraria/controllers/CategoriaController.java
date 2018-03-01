package br.senai.sp.info.pweb.livraria.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.senai.sp.info.pweb.livraria.dao.jdbc.CategoriaDAO;
import br.senai.sp.info.pweb.livraria.models.Categoria;
import br.senai.sp.info.pweb.livraria.models.Usuario;
import br.senai.sp.info.pweb.livraria.util.SessionUtils;

@Controller
public class CategoriaController {
	
	@Autowired
	private CategoriaDAO categoriaDAO;
	@Autowired
	private SessionUtils sessionUtils;
	
	/**
	 * Abre o formulário de cadastro de categoria
	 * @return
	 */
	@GetMapping("/app/categoria/novo")
	// Model -> Objeto que envia dados para view
	public String abreMain (Model model) {
		
		// Buscando as categorias do usuário logado
		Usuario usuarioLogado = sessionUtils.getUsuarioLogado();
		List<Categoria> categorias = categoriaDAO.searchAllByUser(usuarioLogado);
		
		model.addAttribute("categorias", categorias);
		return "categoria/main";
	}
	
	@GetMapping("/app/categoria/deletar")
	public String deletar (@RequestParam(name = "id", required=true) Long id, Categoria categoria) {
		
		// Aplica do Id do get na categoria
		categoria.setId(id);
		
		// Remove a categoria do banco de daods
		categoriaDAO.delete(categoria);
		
		return "redirect:/app/categoria/novo";
	}
	
	@PostMapping("/app/categoria/salvar")
	public String salvar (Categoria categoria, HttpSession session) {
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
		
		categoria.setUsuario(usuarioLogado);
		categoriaDAO.persistence(categoria);
		
		return "redirect:/app/categoria/novo";
	}
	
}
