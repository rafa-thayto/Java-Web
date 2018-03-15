package br.senai.sp.info.pweb.livraria.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.senai.sp.info.pweb.livraria.utils.SessionUtils;

public class AutenticacaoPorSessaoInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private SessionUtils session;
	
	//Método semelhante ao doFilter do WebFilter
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		boolean necessitaAutenticacao = request.getRequestURI().contains("/app");
		 
		 if(necessitaAutenticacao && ! session.isUsuarioLogado()) {
			 
			 // Restringe o acesso ao controller
			 response.setStatus(403);
			 return false;
			 
		 } else {
			 
			 // Libera o acesso ao controller
			 return true;
			 
		 }
		
	} // Fim do preHandle
	
}
