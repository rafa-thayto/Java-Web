package br.senai.sp.info.pweb.livraria.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.senai.sp.info.pweb.livraria.utils.SessionUtils;

@Component
// @WebFilter("/*") = não utilizaremos o Filter, pois usaremos o Interceptor do Spring
//Para assim, utuilizarmos os reursos de injeção de dependência (@Autowired e @Component)
public class AutenticacaoPorSessaoFilter extends HttpFilter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private SessionUtils session;

	@Override
	public void destroy() {
		
	}
	
	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		 boolean necessitaAutenticacao = request.getRequestURI().contains("/app");
		 
		 if(necessitaAutenticacao && ! session.isUsuarioLogado()) {
			 
			 response.setStatus(403);
			 
		 } else {
			 
			 chain.doFilter(request, response);
			 
		 }
		
	}
	
}
