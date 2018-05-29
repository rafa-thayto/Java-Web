package br.senai.sp.info.pweb.jucacontrol.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import br.senai.sp.info.pweb.jucacontrol.dao.UsuarioDAO;
import br.senai.sp.info.pweb.jucacontrol.exceptions.EntidadeNaoEncontradaException;
import br.senai.sp.info.pweb.jucacontrol.exceptions.ValidacaoException;
import br.senai.sp.info.pweb.jucacontrol.models.Usuario;

@Service
public class UsuarioService {

	// busca no banco
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	// meio ponto Matheus (não sei qual)
	public Usuario buscarPorEmailESenha(Usuario usuario, BindingResult bindingResult) 
			throws ValidacaoException, EntidadeNaoEncontradaException {
		// erro de validacao
		if (bindingResult.hasFieldErrors("email") || bindingResult.hasFieldErrors("senha")) {
			// gerar uma exception
			throw new ValidacaoException();
		}
		
		// verifica se o usuario existe atraves do email e senha
		usuario.hashearSenha();
		Usuario usuarioBuscado = 
				usuarioDAO.buscarPorEmailESenha(usuario.getEmail(), usuario.getSenha());
		
		if (usuarioBuscado == null) {
			throw new EntidadeNaoEncontradaException();
		}
		
		return usuarioBuscado;
		
	}
	
}
