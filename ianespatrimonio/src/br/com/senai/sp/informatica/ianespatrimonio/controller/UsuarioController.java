package br.com.senai.sp.informatica.ianespatrimonio.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.sp.informatica.ianespatrimonio.dao.UsuarioDAO;
import br.com.senai.sp.informatica.ianespatrimonio.model.TiposUsuario;
import br.com.senai.sp.informatica.ianespatrimonio.model.Usuario;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	/**
	 * Authenticate the user
	 * Catch the errors if they exist and shows on the screen
	 * @return
	 */
	@PostMapping(value = "/user/signin")
	public String signIn(@Valid Usuario usuario, BindingResult brUsuario, HttpSession session) {
		
		usuario.hashearSenha();
		Usuario usuarioBuscado = usuarioDAO.buscarPorEmailESenha(usuario.getEmail(), usuario.getSenha());
		if (usuarioBuscado == null) {
			brUsuario.addError(new FieldError("usuario", "email", "E-mail ou senha incorretos"));
		}
		
		if (brUsuario.hasFieldErrors("email") || brUsuario.hasFieldErrors("senha")) {
			return "index";
		}
		
		// Adding user in the session
		session.setAttribute("usuarioAutenticado", usuarioBuscado);
		
		return "redirect:/app/";
	}
	
	/**
	 * Register the user in db
	 * @return
	 */
	@PostMapping(value = "/user/signup")
	public String signUp(@Valid Usuario usuario, BindingResult brUsuario,
			@RequestParam(name = "confirmarSenha", required = true) String confirmarSenha,
			@RequestParam(name = "isAdministrador", required = true) Boolean isAdministrador) {
		
		// Validating if register
		if (usuario.getId() == null) {
			
			// Checks whether(if) the passwords match
			if (!confirmarSenha.equals(usuario.getSenha())) {
				brUsuario.addError(new FieldError("usuario", "senha", "As senhas devem coincidir"));
			}
			
			// Check if email is already being used 
			if (usuarioDAO.buscarPorEmail(usuario.getEmail()) != null) {
				brUsuario.addError(new FieldError("usuario", "email", "O e-mail selecionado já está sendo utilizado"));
			}
			
			// Check if the form has errors and reopens
			if (brUsuario.hasErrors()) {
				return "user/form";
			}
			
		} else {
			
			// Change validations
			if (brUsuario.hasFieldErrors("nome") || brUsuario.hasFieldErrors("sobrenome")) {
				return "user/form";
			}
			
		}
		
		if (isAdministrador != null) {
			usuario.setTipo(TiposUsuario.ADMINISTRADOR);
		} else {
			usuario.setTipo(TiposUsuario.COMUM);
		}
		
		// user persisting after validations
		if (usuario.getId() == null) {
			
			// Hash the password
			usuario.hashearSenha();
			usuarioDAO.persistir(usuario);
		
		// Change the user
		} else {
			Usuario usuarioBanco = usuarioDAO.buscarId(usuario.getId());
			usuarioBanco.setNome(usuario.getNome());
			usuarioBanco.setSobrenome(usuario.getSobrenome());
			usuarioBanco.setTipo(usuario.getTipo());
			
			usuarioDAO.alterar(usuarioBanco);
		}
		
		return "index";
	}
	
	/**
	 * Sign out the user and kill session
	 * @return
	 */
	@PostMapping(value = "/user/signout")
	public String signOut(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
}
