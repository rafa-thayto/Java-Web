package br.senai.sp.info.pweb.jucacontrol.controllers;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.senai.sp.info.pweb.jucacontrol.dao.CategoriaOcorrenciaDAO;
import br.senai.sp.info.pweb.jucacontrol.dao.OcorrenciaDAO;
import br.senai.sp.info.pweb.jucacontrol.models.BuscaPorSituacaoOcorrencia;
import br.senai.sp.info.pweb.jucacontrol.models.Ocorrencia;
import br.senai.sp.info.pweb.jucacontrol.models.Usuario;

@Controller
@RequestMapping("/app")
public class OcorrenciaController {
	
	@Autowired
	private CategoriaOcorrenciaDAO categoriaOcorrenciaDAO;
	
	@Autowired
	private OcorrenciaDAO ocorrenciaDAO;
		
	@GetMapping({"", "/"})
	public String abrirListaOcorrencia(Model model, 
				@RequestParam(required = false, name = "pesquisa") BuscaPorSituacaoOcorrencia situacao) {
		
		// Verificando se a situa��o foi informada
		if (situacao == null) {
			situacao = BuscaPorSituacaoOcorrencia.TODOS;
		}
		
		model.addAttribute("ocorrencias", ocorrenciaDAO.buscarPorSituacao(situacao));
		model.addAttribute("tiposBusca", BuscaPorSituacaoOcorrencia.values());
		
		return "ocorrencia/lista";
	}
	
	@GetMapping({"/ocorrencia/nova"})
	public String abriFormOcorrencia(Model model) {
		
		model.addAttribute("ocorrencia", new Ocorrencia());
		model.addAttribute("categorias", categoriaOcorrenciaDAO.buscarTodos());
		
		return "ocorrencia/form";
	}
	
	@GetMapping("/ocorrencia/editar")
	public String abrirEditarOcorrencia(@RequestParam(required = true) Long id, Model model) {
		
		model.addAttribute("ocorrencia", ocorrenciaDAO.buscar(id));
		model.addAttribute("categorias", categoriaOcorrenciaDAO.buscarTodos());
		
		
		return "ocorrencia/form";
	}
	
	@GetMapping("/ocorrencia/assumir")
	public String assumirOcorrencia(@RequestParam(required = true) Long id, HttpSession session, RedirectAttributes redirectAttributes) {
		
		// Pegar a ocorr�ncia para aplicart um t�cnico
		Ocorrencia o = ocorrenciaDAO.buscar(id);
		
		// Pega o usu�rio logado
		Usuario logado = (Usuario) session.getAttribute("usuarioAutenticado");
		
		// Seta o usu�rio logado como quem atendeu icirrebcua
		o.setTecnico(logado);
		
		o.setDataModificacao(new Date());
		
		// Salvando ocorrencia nova no banco
		ocorrenciaDAO.alterar(o);
		
		return "redirect:/app";
	}
	
	@GetMapping("/ocorrencia/encerrar")
	public String concluirOcorrencia(@RequestParam(required = true) Long id, RedirectAttributes redirectAttributes) {
		
		Ocorrencia o = ocorrenciaDAO.buscar(id);
		o.setDataModificacao(new Date());
		o.setDataConclusao(new Date());
		
		ocorrenciaDAO.alterar(o);
		return "redirect:/app";
	}
	
	@PostMapping("/ocorrencia/salvar")
	public String salvar(@Valid Ocorrencia ocorrencia, BindingResult brOcorrencia, Model model, HttpSession session) {		
		
		//Verificando se possui erros
		if(brOcorrencia.hasErrors()) {
			
			//Reenvia as categorias para a tela para, caso de erros de valida��o
			model.addAttribute("categorias", categoriaOcorrenciaDAO.buscarTodos());
			return "ocorrencia/form";
		}
		
		
		
		//Aplicando os valores padr�es do sistema
		ocorrencia.setDataModificacao(new Date());
		
		
		
		//Verificando se cadastro
		if(ocorrencia.getId() == null) {
			//Pegando o usu�rio logado
			Usuario usuarioAutenticado = (Usuario) session.getAttribute("usuarioAutenticado");
			//Determina que o usuario autenticado � o emissor da ocorr�ncia
			ocorrencia.setEmissor(usuarioAutenticado);
			ocorrencia.setDataCadastro(new Date());
			
			ocorrenciaDAO.persistir(ocorrencia);
		}
		//Verificando se altera��o
		else {
			//Pegando o objeto que ser� alterado
			Ocorrencia ocorrenciaAlterada = ocorrenciaDAO.buscar(ocorrencia.getId());
			
			//copyProperties -> Passa as propriedades de um objeto para outro
			//(objetoFonteDeDados, objetoQueReceberaOsDados)
			BeanUtils.copyProperties(ocorrencia, ocorrenciaAlterada, "id", "dataCadastro", "emissor");
			
			ocorrenciaDAO.alterar(ocorrenciaAlterada);
		}
		
		return "redirect:/app";
	}
	

}
