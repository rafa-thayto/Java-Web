package br.senai.sp.info.pweb.livraria.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.senai.sp.info.pweb.livraria.util.SessionUtils;

@Component
public class AutenticacaoPorSessaoInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	private SessionUtils sessionUtils;
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		boolean necessitaAutenticacao= request.getRequestURI().contains("/app");
		
		if (necessitaAutenticacao && ! sessionUtils.isUsuarioLogado()
				) {
			response.setStatus(401);
			
			//se retorna false restring o acesso
			return false;
			
		}else {
			
			//No interceptor, se retorna true libera acesso
			return true;
		}
		
	}

}
