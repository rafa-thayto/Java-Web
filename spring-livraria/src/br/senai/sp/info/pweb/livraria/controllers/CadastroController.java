package br.senai.sp.info.pweb.livraria.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.senai.sp.info.pweb.livraria.dao.jdbc.CategoriaDAO;
import br.senai.sp.info.pweb.livraria.models.Categoria;
import br.senai.sp.info.pweb.livraria.models.Usuario;

@Controller

// Ao colocar esta annotation na classe, todo mapping dela ter� um prefixo definido no value, que, no caso, � "/app/cadastro"
@RequestMapping(value="/app")
public class CadastroController {
	
	@Autowired
	private CategoriaDAO categoriaDao;
	
	/**
	 * 
	 * Abre a p�gina de cadastro
	 * 
	 * @return
	 */
	@GetMapping("/cadastro")
	public String abrirForm(@RequestParam(name = "id", required = false) Long id, Model model) {
		
		// Se o id for informado, � uma altera��o.
		// Logo, buscaremos no banco de dados para envi�-lo para tela
		if(id != null) {
			
			Categoria cat = categoriaDao.buscar(id);
			model.addAttribute("categoria", cat);
			
		}
		
		return "Cadastro/form";
		
	}
	
	/**
	 * 
	 *  Abre a p�gina de cadastro de categorias e livros.
	 * 
	 * @param model - objeto que envia dados para o view
	 * @return
	 */
	@GetMapping(value = {"/", ""}) // Aceita terminar com "/" ou sem
	public String abrePaginaDeCadastros(Model model, HttpSession session) {
		
		// Busca o usu�rio logado na sess�o
		Usuario logado = (Usuario) session.getAttribute("usuarioLogado");
		
		// Passo o usu�rio logado para buscar suas categorias
		model.addAttribute("categorias", categoriaDao.buscarTodos(logado));
		
		return "Cadastro/lista";
		
	}

}