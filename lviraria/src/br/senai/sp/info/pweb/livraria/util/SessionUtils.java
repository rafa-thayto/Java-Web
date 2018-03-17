package br.senai.sp.info.pweb.livraria.util;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.senai.sp.info.pweb.livraria.models.Usuario;


@Component //Marca a classe para o Spring injetar um objeto com @Autowired
public class SessionUtils {

	
	/*
	 * ARMAZENA A CHAVE ONDE FICAR� O USUARIO AUTENTICADO 
	 */
	public static final String USUARIO_CHAVE = "usuario";
	
	/**
	 * retorna o usuario armazendao na sess�o
	 * @return
	 */
	public Usuario getUsuarioLogado() {
		return (Usuario) session.getAttribute(USUARIO_CHAVE);
	}
	
	
	@Autowired
	private HttpSession session;
	
	/**
	 * Guarda o usuario que est� autenticado na sess�o
	 */
	public void setUsuarioLogado(Usuario usuario) {
		
		session.setAttribute(USUARIO_CHAVE, usuario);
		
	}
	
	/**
	 * Verifica se o usurio est� na sess�o do cliente
	 * @return
	 */
	public boolean isUsuarioLogado() {
		return session.getAttribute(USUARIO_CHAVE) != null;
	}
	
	/**
	 * Deleta o arquivo de sessao do cliente atual
	 */
	public void matarSessao() {
		//session.setAttribute("usuario", null);
		session.invalidate();
	}
	
	
	
	
}