package br.senai.sp.info.pweb.jucacontrol.controllers;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.jboss.jandex.TypeTarget.Usage;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.senai.sp.info.pweb.jucacontrol.dao.UsuarioDAO;
import br.senai.sp.info.pweb.jucacontrol.models.TiposUsuario;
import br.senai.sp.info.pweb.jucacontrol.models.Usuario;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@GetMapping(value = {"/", ""})
	public String abrirLogin(Model model) {
		
		return "index";
	}
	
	@GetMapping("/app/adm/usuario/editar")
	public String abrirEdicao(Model model, @RequestParam(name = "id", required = true) Long id, HttpServletResponse response) throws IOException {
		
		//Buscar o usu�rio pelo id
		Usuario usuarioBuscado = usuarioDAO.buscar(id);
		model.addAttribute("usuario", usuarioBuscado);
		
		return "usuario/form";
	}
	
	@GetMapping("/app/adm/usuario")
	public String abrirLista(Model model) {
		
		model.addAttribute("usuarios", usuarioDAO.buscarTodos());
		
		return "usuario/lista";
	}
	
	@GetMapping("/app/adm/usuario/novo")
	public String abrirFormNovoUsuario(Model model) {
		
		//Passando o usu�rio vazio para o model attribute
		model.addAttribute("usuario", new Usuario());
		
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
		
		usuarioDAO.deletar(usuarioDAO.buscar(id));
		
		return "redirect:/app/adm/usuario";
	}
	
	@PostMapping( value = {"/app/adm/usuario/salvar"})
	public String salvar(@Valid Usuario usuario, BindingResult brUsuario,
						@RequestParam(name = "confirmacaoSenha", required = false) String confirmacao,
						@RequestParam(name = "administrador", required = false) Boolean isAdministrador) {
		
		//VERIFICANDO SE CADASTRO
		if(usuario.getId() == null) {
			
			//Checando se a confirma��o de senha N�O for igual a senha
			if(!confirmacao.equals(usuario.getSenha())) {
				brUsuario.addError(new FieldError("usuario", "senha", "As senhas n�o coincidem"));
			}
			
			//Verificando se email j� existe
			if(usuarioDAO.buscarPorEmail(usuario.getEmail()) != null) {
				brUsuario.addError(new FieldError("usuario", "email", "O email '" + usuario.getEmail() + "' j� est� em uso"));
			}
			
			//Verificando se o binding result contem erros
			if(brUsuario.hasErrors()) {
				return "usuario/form"; //Reabre a tela de cadastro
			}
			
		}
		//VERIFICANDO SE � ALTERA��O
		else {
			if(	brUsuario.hasFieldErrors("nome") || 
				brUsuario.hasFieldErrors("sobrenome")){
				return "usuario/form";
			}
		}
		
		
		
		
		
		
		//Verificando se usu�rio � administrador
		if(isAdministrador != null) {
			usuario.setTipo(TiposUsuario.ADMINISTRADOR);
		}else {
			usuario.setTipo(TiposUsuario.COMUM);
		}
		
		
		//CASO CADASTRO...
		if(usuario.getId() == null) {
			//Armazena o usu�rio no banco de dados
			usuario.hashearSenha();
			usuarioDAO.persistir(usuario);
		}else {
			
			//BUscar o usu�rio do banco
			Usuario usuarioBanco = usuarioDAO.buscar(usuario.getId());
			
			//Altera com os dados que recebi do formul�rio
			usuarioBanco.setNome(usuario.getNome());
			usuarioBanco.setSobrenome(usuario.getSobrenome());
			usuarioBanco.setTipo(usuario.getTipo());
			
			//Altera o usu�rio do
			usuarioDAO.alterar(usuarioBanco);
		}
		
		return "redirect:/app/adm/usuario";
	}
	
	@PostMapping({"/usuario/autenticar"})
	//@Valid - DEtermina que o Spring deve validar o objeto
	//BindingResult - Armazena os poss�veis erros de valida��o que ocorreram no objeto
	public String autenticar(@Valid Usuario usuario, BindingResult brUsuario) {
		
		//VErificando se houveram erros no binding result
		if(	brUsuario.hasFieldErrors("email") || 
			brUsuario.hasFieldErrors("senha")) {
			
			System.out.println("CAPTUROU OS ERROS");
			
			return "index";
		}

		return "redirect:/app/";
	}
	
	@GetMapping({"/sair"})
	public String logout() {
		
		return "redirect:/";
	}

}
