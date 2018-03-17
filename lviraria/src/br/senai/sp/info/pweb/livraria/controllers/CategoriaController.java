package br.senai.sp.info.pweb.livraria.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	 * Abre o formulario de cadastro de categoria
	 * 
	 * @return
	 */
	@GetMapping("/app/categoria")
	// Model -> Objeto que envia dados para a view
	public String abrirMain(Model model, @RequestParam(name = "id", required = false) Long id) {

		// Verifica se é uma alteração
		if (id != null) {
			Categoria cat = categoriaDAO.buscar(id);
			model.addAttribute("categoria", cat);
		}

		// Buscando as categorias
		Usuario usuarioLogado = sessionUtils.getUsuarioLogado();
		List<Categoria> categorias = categoriaDAO.buscarTodosPorUsuario(usuarioLogado);

		// Enviando lista para a view
		model.addAttribute("categorias", categorias);

		return "categoria/main";
	}

	@GetMapping("/app/categoria/deletar")
	// Para pegar o parametro GET usamos @RequestParam
	// nome = nome do parametro
	// required = determina se o cliente será obrigado a passar o parametro
	public String deletar(@RequestParam(name = "id", required = true) Long id, Categoria categoria) {

		// aplica o id do get na categoria
		categoria.setId(id);

		// Remove a categoria do banco
		categoriaDAO.deletar(categoria);

		return "redirect:/app/categoria";
	}

	@PostMapping("/app/categoria/salvar")
	public String salvar(Categoria categoria, HttpSession session) {
		// Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
		categoria.setUsuario(sessionUtils.getUsuarioLogado());

		if (categoria.getId() != null) {
			categoriaDAO.alterar(categoria);
		} else {

			categoriaDAO.persistir(categoria);
		}
		// redireciona pro abreForm
		return "redirect:/app/" + "categoria";

	}
	
	@PostMapping("/app/categoria/salvar/{id}")
	public String salvar2(Categoria categoria, HttpSession session, @PathVariable(name = "id") Long id) {
		// Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
		categoria.setUsuario(sessionUtils.getUsuarioLogado());
		categoria.setId(id);

		if (categoria.getId() != null) {
			categoriaDAO.alterar(categoria);
		} else {

			categoriaDAO.persistir(categoria);
		}
		// redireciona pro abreForm
		return "redirect:/app/" + "categoria";

	}
}
