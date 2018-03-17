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

//@WebFilter("/*") - Não se usa filte no Spring, mas sim Interceptor
public class AutenticacaoPorsessaoFilter extends HttpFilter {

	@Autowired
	private SessionUtils sessionUtils;
	
	@Override
	public void destroy() {
		
	}
	
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		boolean necessitaAutenticacap = req.getRequestURI().contains("/app");
		if (necessitaAutenticacap && !sessionUtils.isUsuarioLogado()) {
			res.setStatus(401);
		} else {
			chain.doFilter(req, res);
		}
	}

}
