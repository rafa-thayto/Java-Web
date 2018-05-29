package br.senai.sp.info.pweb.jucacontrol.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import br.senai.sp.info.pweb.jucacontrol.models.Usuario;
import br.senai.sp.info.pweb.jucacontrol.utils.JwtUtils;

@Configuration
public class JwtFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		// Convertendo para HttpServletRequest para obter o header
		HttpServletRequest request = (HttpServletRequest) req;
		
		String authorization = request.getHeader("Authorization");
		
		// Verificando se a autorização foi enviada
		if (authorization != null) {
			
			// Se o que foi enviado coincide com Bearer <token>
			if (authorization.matches("(Bearer )(\\w|\\.|\\-)+")) {
				
				String token = authorization.split(" ")[1];
				
				try {
					
					// 1º Valida o token
					JwtUtils.validarToken(token);
					
					// 2º Extrai dados que estão presentes no token
					Usuario usuarioToken = JwtUtils.extrairUsuarioDoToken(token);
					
					// 3º 
					SecurityContextHolder.getContext().setAuthentication(usuarioToken);
					
				} catch (Exception e) {
					
					System.out.println("Token Inválido");
					
				}
				
				System.out.println("Token " + token);
				
			} else {
				System.out.println("Token inválido");
			}
			
		} else {
			System.out.println("Authorization não informado");
		}
		
		// Segura o chain
		chain.doFilter(req, res);
		
	}

}
