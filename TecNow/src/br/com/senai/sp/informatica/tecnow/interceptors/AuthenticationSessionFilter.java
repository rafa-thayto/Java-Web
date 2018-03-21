package br.com.senai.sp.informatica.tecnow.interceptors;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.senai.sp.informatica.tecnow.utils.SessionUtils;

public class AuthenticationSessionFilter extends HttpFilter {

	@Autowired
	private SessionUtils sessionUtils;
	
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		boolean needAuth = req.getRequestURI().contains("/app");
		
		if (needAuth && !sessionUtils.isLoggedUser()) {
			res.setStatus(401);
		} else {
			chain.doFilter(req, res);
		}
		
	}
	
	
	
}
