package br.com.senai.sp.informatica.ianespatrimonio.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.com.senai.sp.informatica.ianespatrimonio.model.TiposUsuario;
import br.com.senai.sp.informatica.ianespatrimonio.model.Usuario;

@Component
public class AutenticacaoInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private HttpSession session;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean necessitaAutenticacao = request.getRequestURI().contains("/app");
		Usuario usuarioAutenticado = (Usuario) session.getAttribute("usuarioAutenticado");
		boolean usuarioEstaAutenticado = usuarioAutenticado != null;
		boolean necessitaSerAdministrador = request.getRequestURI().contains("/adm");
		
		// Caso a p�gina precise de autentica��o de algum tipo de usu�rio seja adm ou n�o
		if (necessitaAutenticacao) {
			// Caso esteja autenticado
			if (usuarioEstaAutenticado) {
				// Caso o usu�rio precise ser administrador
				if (necessitaSerAdministrador && usuarioAutenticado.getTipo() != TiposUsuario.ADMINISTRADOR) {
					response.sendError(403);
					return false;
				}
				
			}
			
		// Caso n�o esteja autenticado
		} else {
			response.sendError(401);
			return false;
		}
		
		// Se tudo der certo autentique
		return true;
	}
			
}
