package br.senai.sp.info.pweb.livraria.util;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.senai.sp.info.pweb.livraria.models.Usuario;

@Component
public class SessionUtils {
	/*
	 * Armazena a chave onde ficará o usuário autenticado
	 */
	public static final String USUARIO_CHAVE = "usuario";
	@Autowired
	private HttpSession session;
	
	
	public Usuario getUsuarioLogado () {
		return (Usuario) session.getAttribute(USUARIO_CHAVE);
	}
	
	/**
	 * Guarda o usuário que setá autenticado
	 * na sessão
	 */
	public void setUsuarioLogado (Usuario usuario) {
		session.setAttribute(USUARIO_CHAVE, usuario);
	}
	/**
	 * Verifica se o usuário esta na sessão do cliente
	 * @return
	 */
	public boolean isUsuarioLogado () {
		return session.getAttribute(USUARIO_CHAVE) != null;
	}
	/**
	 * Deleta o arquivo de sessão do usuário
	 */
	public void matarSessao () {
		session.invalidate();
	}
}
