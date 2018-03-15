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

// Ao colocar esta annotation na classe, todo mapping dela terá um prefixo definido no value, que, no caso, é "/app/cadastro"
@RequestMapping(value="/app")
public class CadastroController {
	
	@Autowired
	private CategoriaDAO categoriaDao;
	
	/**
	 * 
	 * Abre a página de cadastro
	 * 
	 * @return
	 */
	@GetMapping("/cadastro")
	public String abrirForm(@RequestParam(name = "id", required = false) Long id, Model model) {
		
		// Se o id for informado, é uma alteração.
		// Logo, buscaremos no banco de dados para enviá-lo para tela
		if(id != null) {
			
			Categoria cat = categoriaDao.buscar(id);
			model.addAttribute("categoria", cat);
			
		}
		
		return "Cadastro/form";
		
	}
	
	/**
	 * 
	 *  Abre a página de cadastro de categorias e livros.
	 * 
	 * @param model - objeto que envia dados para o view
	 * @return
	 */
	@GetMapping(value = {"/", ""}) // Aceita terminar com "/" ou sem
	public String abrePaginaDeCadastros(Model model, HttpSession session) {
		
		// Busca o usuário logado na sessão
		Usuario logado = (Usuario) session.getAttribute("usuarioLogado");
		
		// Passo o usuário logado para buscar suas categorias
		model.addAttribute("categorias", categoriaDao.buscarTodos(logado));
		
		return "Cadastro/lista";
		
	}

}