package br.com.senai.sp.informatica.mercadofamilia.utils;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.senai.sp.informatica.mercadofamilia.models.Usuario;

@Component
public class SessionUtils {
	// Armazena a chave onde ficar� o usuario autenticado
	public static final String USUARIO_CHAVE = "usuario";
	@Autowired
	private HttpSession session;
	
	/**
	 * Pega o usu�rio que est� na sess�o
	 * @return
	 */
	public Usuario getUsuarioLogado () {
		return (Usuario) session.getAttribute(USUARIO_CHAVE);
	}
	/**
	 * Guarda o usu�rio na sess�o
	 * @param usuario
	 */
	public void setUsuarioLogado (Usuario usuario) {
		session.setAttribute(USUARIO_CHAVE, usuario);
	}
	/**
	 * Verifica se o usu�rio est� logado na sess�o
	 * @return
	 */
	public boolean isUsuarioLogado () {
		return session.getAttribute(USUARIO_CHAVE) != null;
	}
	/**
	 * Deleta o aquivo de sess�o do usu�rio
	 */
	public void killSession () {
		session.invalidate();
	}
	
}
