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
	 * Abre o formul�rio de cadastro de categoria
	 * @return
	 */
	@GetMapping("/app/categoria")
	// Model -> Objeto que envia dados para view
	public String abreMain (Model model,
			@RequestParam(name = "id", required = false) Long id) {
		// Verifica se � uma altera��o (se o id n�o � nulo)
		if (id != null) {
			Categoria cat = categoriaDAO.search(id);
			model.addAttribute("categoria", cat);
		}
		
		// Buscando as categorias do usu�rio logado
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
		
		return "redirect:/app/categoria";
	}
	
	@PostMapping("/app/categoria/salvar")
	public String salvar (Categoria categoria, HttpSession session) {
		// Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
		
		categoria.setUsuario(sessionUtils.getUsuarioLogado());
		// SE a catagoria n�o tiver ID significa que � um cadastro
		if (categoria.getId() == null) {
			categoriaDAO.persistence(categoria);
		} else {
		// SENAO � uma altera��o
			categoriaDAO.change(categoria);
		}
		
		return "redirect:/app/categoria";
	}
	
}
