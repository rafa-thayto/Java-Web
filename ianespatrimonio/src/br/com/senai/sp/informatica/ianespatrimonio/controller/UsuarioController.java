package br.com.senai.sp.informatica.ianespatrimonio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.senai.sp.informatica.ianespatrimonio.dao.UsuarioDAO;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@GetMapping(value = {"/", ""})
	public String abrirLogin() {
		return "index";
	}
	
}
