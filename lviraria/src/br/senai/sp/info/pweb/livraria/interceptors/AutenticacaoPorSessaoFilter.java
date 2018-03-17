package br.senai.sp.info.pweb.livraria.interceptors;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import br.senai.sp.info.pweb.livraria.util.SessionUtils;

//@WebFilter("/*") - Não se usa Filter no Spring, mas sim Interceptor
public class AutenticacaoPorSessaoFilter extends HttpFilter{
	
	@Autowired
	private SessionUtils SessionUtils;
	
	@Override
	public void destroy() {
		
	}
	
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("Filtrouuu");
		
		boolean necessitaAutenticacao= req.getRequestURI().contains("/app");
		
		if (necessitaAutenticacao && ! SessionUtils.isUsuarioLogado()
				) {
			res.setStatus(401);
		}else {
			chain.doFilter(req, res);
		}
	
	}
	
	

}
