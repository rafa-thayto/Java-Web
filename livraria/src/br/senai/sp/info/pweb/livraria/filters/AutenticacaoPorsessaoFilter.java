package br.senai.sp.info.pweb.livraria.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class AutenticacaoPorsessaoFilter extends HttpFilter {

	@Override
	public void destroy() {
		
	}
	
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		boolean necessitaAutenticacap = req.getRequestURI().contains("/app");
		if (necessitaAutenticacap && req.getSession().getAttribute("usuario") == null) {
			res.setStatus(403);
		} else {
			chain.doFilter(req, res);
		}
	}

}
