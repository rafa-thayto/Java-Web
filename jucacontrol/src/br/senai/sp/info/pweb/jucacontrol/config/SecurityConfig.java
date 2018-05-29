package br.senai.sp.info.pweb.jucacontrol.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtFilter jwtFilter;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			// Configuração dos endpoints - autorização de requisitos
			.and().authorizeRequests()
				// Uma rota para ser pública
				.antMatchers("/rest/auth/jwt").permitAll()
				// Para qualquer requisição, bloquear
				.anyRequest().authenticated()
				.and()
					.csrf().disable()
					.cors();
		
		// Registro do filtro
		http
			.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		
	}
	
}
