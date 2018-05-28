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

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	public Usuario buscarPorEmailESenha(Usuario usuario, BindingResult bindingResult) 
			throws ValidacaoException, EntidadeNaoEncontradaException {
		
		if (bindingResult.hasFieldErrors("email") || bindingResult.hasFieldErrors("senha")) {
			throw new ValidacaoException();
		}
		
		usuario.hashearSenha();
		Usuario usuarioBuscado = usuarioDAO.buscarPorEmailESenha(usuario.getEmail(), usuario.getSenha());
		
		if (usuarioBuscado == null) {
			throw new EntidadeNaoEncontradaException();
		}
		
		return usuarioBuscado; 
		
	}
	
}
