package br.com.senai.sp.informatica.tecnow.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.com.senai.sp.informatica.tecnow.utils.SessionUtils;

@Component
public class AuthenticationSessionInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private SessionUtils sessionUtils;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean needAuth = request.getRequestURI().contains("/app");
		
		if (needAuth && ! sessionUtils.isLoggedUser()) {
			response.setStatus(401);
			
			// if false, restricts access
			return false;
			
		} else {
			
			// If true, free access
			return true;
		}
		
	}
}
