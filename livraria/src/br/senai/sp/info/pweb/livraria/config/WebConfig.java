package br.senai.sp.info.pweb.livraria.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration // Determina que a seguinte classe(WebConfig) � de configura��o do Spring
@EnableWebMvc // Habilita o m�dulo de MVC do Spring Framework
@ComponentScan("br.senai.sp.info.pweb.livraria")
public class WebConfig implements WebMvcConfigurer {

	// Determina onde o spring encontrar� as views
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		// Registrando
		registry.viewResolver(resolver);
	}
	
}
