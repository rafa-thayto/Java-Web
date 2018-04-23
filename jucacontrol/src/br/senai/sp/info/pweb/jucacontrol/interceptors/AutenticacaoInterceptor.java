package br.senai.sp.info.pweb.jucacontrol.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.senai.sp.info.pweb.jucacontrol.models.TiposUsuario;
import br.senai.sp.info.pweb.jucacontrol.models.Usuario;

@Component
public class AutenticacaoInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//Se a URL contem /app
		boolean necessitaAutenticacao = request.getRequestURI().contains("/app");
		boolean necessitaSerAdm = request.getRequestURI().contains("/adm");
		
		Usuario usuarioAutenticado = (Usuario) request.getSession().getAttribute("usuarioAutenticado");
		boolean estaLogado = usuarioAutenticado != null;
		
		//Realizandoo filtro
		if(necessitaAutenticacao && !estaLogado) {
			return false;
		}
		//Necessita ser adm
		else if(necessitaSerAdm && usuarioAutenticado.getTipo() != TiposUsuario.ADMINISTRADOR) {
			return false;
		}
		else {
			return true;
		}
		
	}

}
