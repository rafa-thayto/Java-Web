package br.senai.sp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.senai.sp.model.Usuario;

@WebFilter("/admin/*")
public class FilterLogin implements Filter {

	public FilterLogin() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request
			, ServletResponse response
			, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = 
				((HttpServletRequest) request)
				.getSession();
		Usuario usuario = 
				(Usuario) session
				.getAttribute("session_usuario");

		if (usuario == null) {
			((HttpServletResponse) response)
			.sendRedirect
			("/cadastro-livros/login.jsp");
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) 
			throws ServletException {

	}

}
