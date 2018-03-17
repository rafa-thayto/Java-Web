package br.senai.sp.info.pweb.livraria.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import br.senai.sp.info.pweb.livraria.interceptors.AutenticacaoPorSessaoInterceptor;
import br.senai.sp.info.pweb.livraria.util.SessionUtils;

@Configuration //determina que esta classe é de configuração
@EnableWebMvc //Habilita o módulo de MVC do Spring
@ComponentScan("br.senai.sp.info.pweb.livraria")//mapeia Livraria
public class WebConfig implements WebMvcConfigurer{
	
	
	
	
	
	/*
	 * injeta o interceptor para utiliza-lo no addInterceptors
	 */
	@Autowired
	private AutenticacaoPorSessaoInterceptor interceptor;
	
	
	
	
	
	
	
	/**
	 * Registra todos os interceptoirs utilizados na aplicação
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(interceptor)
		.addPathPatterns("/**");
		
	}
	
	
	
	
	
	
	
	

	//Determina onde o spring encontrará as views
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		//registrando as configurações
		registry.viewResolver(resolver);
		
	}
	
	
	
	
	
	
	
	
	
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	registry.addResourceHandler("/assets/**")
	.addResourceLocations("/assets/");
	
	}
}
