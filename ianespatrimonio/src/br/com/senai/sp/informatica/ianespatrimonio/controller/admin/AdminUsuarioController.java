package br.com.senai.sp.informatica.ianespatrimonio.controller.admin;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.senai.sp.informatica.ianespatrimonio.dao.UsuarioDAO;
import br.com.senai.sp.informatica.ianespatrimonio.model.Usuario;

@Controller
@RequestMapping("/app/adm/user")
public class AdminUsuarioController {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	/**
	 * Open the list of users
	 * @param model
	 * @return
	 */
	@GetMapping(value = {"", "/"})
	public String allUsers(Model model) {
		model.addAttribute("usuarios", usuarioDAO.buscarTodos());
		return "user/list";
	}
	
	/**
	 * This method delete the user
	 * @param id
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@PostMapping(value = "/delete")
	public String deleteUser(@RequestParam(required = true) Long id, HttpServletResponse response) throws IOException {
		
		Usuario usuarioDeletar = usuarioDAO.buscarId(id);
		
		// Deleting the user
		usuarioDAO.deletar(usuarioDeletar);
		
		return "redirect:/app/adm/user";
	}
	
}
