package br.senai.sp.info.pweb.livraria.util;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.senai.sp.info.pweb.livraria.models.Usuario;

@Component
public class SessionUtils {
	/*
	 * Armazena a chave onde ficar� o usu�rio autenticado
	 */
	public static final String USUARIO_CHAVE = "usuario";
	@Autowired
	private HttpSession session;
	
	
	public Usuario getUsuarioLogado () {
		return (Usuario) session.getAttribute(USUARIO_CHAVE);
	}
	
	/**
	 * Guarda o usu�rio que set� autenticado
	 * na sess�o
	 */
	public void setUsuarioLogado (Usuario usuario) {
		session.setAttribute(USUARIO_CHAVE, usuario);
	}
	/**
	 * Verifica se o usu�rio esta na sess�o do cliente
	 * @return
	 */
	public boolean isUsuarioLogado () {
		return session.getAttribute(USUARIO_CHAVE) != null;
	}
	/**
	 * Deleta o arquivo de sess�o do usu�rio
	 */
	public void matarSessao () {
		session.invalidate();
	}
}
