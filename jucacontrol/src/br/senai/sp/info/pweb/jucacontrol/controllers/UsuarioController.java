package br.senai.sp.info.pweb.jucacontrol.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.senai.sp.info.pweb.jucacontrol.models.Usuario;

@Controller
public class UsuarioController {
	
	@GetMapping(value = {"/", ""})
	public String abrirLogin(Model model) {
		
		return "index";
	}
	
	@GetMapping("/app/adm/usuario/editar")
	public String abrirEdicao(Model model, @RequestParam(name = "id", required = true) Long id, HttpServletResponse response) throws IOException {
		
		return "usuario/form";
	}
	
	@GetMapping("/app/adm/usuario")
	public String abrirLista(Model model) {
		
		return "usuario/lista";
	}
	
	@GetMapping("/app/adm/usuario/novo")
	public String abrirFormNovoUsuario(Model model) {
		
		return "usuario/form";
	}
	
	@GetMapping("/app/perfil")
	public String abrirFormEditarUsuarioLogado(Model model) {
		
		return "usuario/form";
	}
	
	@GetMapping("/app/alterarSenha")
	public String abrirFormAlterarSenha(Model model) {
		
		return "usuario/alterarSenha";
	}
	
	@GetMapping("/app/adm/usuario/deletar")
	public String deletar(@RequestParam(required = true) Long id, HttpServletResponse response) throws IOException {
		
		return "redirect:/app/adm/usuario";
	}
	
	@PostMapping( value = {"/app/adm/usuario/salvar"})
	public String salvar(Usuario usuario) {
		
		return "redirect:/app/adm/usuario";
	}
	
	@PostMapping({"/usuario/autenticar"})
	//@Valid - DEtermina que o Spring deve validar o objeto
	//BindingResult - Armazena os poss�veis erros de valida��o que ocorreram no objeto
	public String autenticar(@Valid Usuario usuario, BindingResult brUsuario) {

		// Verificando se houveram erros no binding result
		if (brUsuario.hasFieldErrors("email") || brUsuario.hasFieldErrors("senha")) {
			System.out.println("Capturou os erros");
			return "index";
		}
		
		return "redirect:/app/";
	}
	
	@GetMapping({"/sair"})
	public String logout() {
		
		return "redirect:/";
	}

}
