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
import br.senai.sp.info.pweb.livraria.interceptors.AutenticacaoPorsessaoFilter;
import br.senai.sp.info.pweb.livraria.util.SessionUtils;

@Configuration // Determina que a seguinte classe(WebConfig) é de configuração do Spring
@EnableWebMvc // Habilita o módulo de MVC do Spring Framework
@ComponentScan("br.senai.sp.info.pweb.livraria")
public class WebConfig implements WebMvcConfigurer {
	
	/*
	 * Injeto o interceptor para utiliza-lo no
	 * addInterceptors
	 */
	@Autowired AutenticacaoPorSessaoInterceptor interceptor;
	
	/**
	 * Registra todos os interceptor utilizados na aplicação
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry
			.addInterceptor(interceptor)
			.addPathPatterns("/**");
	}

	// Determina onde o spring encontrará as views
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		// Registrando
		registry.viewResolver(resolver);
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
			.addResourceHandler("/assets/**")
			.addResourceLocations("/assets/");
	}

}
