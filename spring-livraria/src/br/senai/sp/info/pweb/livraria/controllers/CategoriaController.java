package br.senai.sp.info.pweb.livraria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.senai.sp.info.pweb.livraria.dao.jdbc.CategoriaDAO;
import br.senai.sp.info.pweb.livraria.models.Categoria;
import br.senai.sp.info.pweb.livraria.utils.SessionUtils;

@Controller
@RequestMapping("/app/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaDAO categoriaDAO;
	
	@Autowired
	private SessionUtils sessionUtils;
	
	
	/**
	 * Deleta uma categoria do banco de dados
	 * @return
	 */
	@GetMapping("/deletar")
	public String deletar( @RequestParam(name = "id", required = true) Long id) {
		
		try {
			
			// Criar um objeto categoria, passar o id e deletar
			
			Categoria c = new Categoria();
			c.setId(id);
			
			categoriaDAO.deletar(c);
			
			return "redirect:/app";
			
		} catch (Exception e) {
			
			
			
		}
		
		return null;
		
	}

	/**
	 * Salva uma categoria no banco de dados
	 * @param categoria - objeto a ser adicionado no banco
	 * @return redireciona à página /app
	 */
	@PostMapping("/salvar")
	public String salvar(Categoria categoria) {
		
		try {
			
			if(categoria.getId() == null) {
				
				categoria.setUsuario(sessionUtils.pegarUsuario());
				
				categoriaDAO.persistir(categoria);
				
			} else {
				
				categoriaDAO.alterar(categoria);
				
			}
			
		} catch( Exception e ) {
			
			throw new RuntimeException(e);
			
		}
		
		return "redirect:/app";
		
	}
			
}
