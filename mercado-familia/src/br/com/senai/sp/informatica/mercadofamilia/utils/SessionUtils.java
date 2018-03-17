package br.com.senai.sp.informatica.mercadofamilia.utils;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.senai.sp.informatica.mercadofamilia.models.Usuario;

@Component
public class SessionUtils {
	// Armazena a chave onde ficará o usuario autenticado
	public static final String USUARIO_CHAVE = "usuario";
	@Autowired
	private HttpSession session;
	
	/**
	 * Pega o usuário que está na sessão
	 * @return
	 */
	public Usuario getUsuarioLogado () {
		return (Usuario) session.getAttribute(USUARIO_CHAVE);
	}
	/**
	 * Guarda o usuário na sessão
	 * @param usuario
	 */
	public void setUsuarioLogado (Usuario usuario) {
		session.setAttribute(USUARIO_CHAVE, usuario);
	}
	/**
	 * Verifica se o usuário está logado na sessão
	 * @return
	 */
	public boolean isUsuarioLogado () {
		return session.getAttribute(USUARIO_CHAVE) != null;
	}
	/**
	 * Deleta o aquivo de sessão do usuário
	 */
	public void killSession () {
		session.invalidate();
	}
	
}
