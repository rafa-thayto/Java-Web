package br.senai.sp.info.pweb.livraria.config;

import org.springframework.context.annotation.Bean;
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

@Configuration
@ComponentScan("br.senai.sp.info.pweb.livraria")
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
	
	
	
	// Ao chamar este método o Spring gerencia-rá as dependências no objeto retornado
	@Bean
	public AutenticacaoPorSessaoInterceptor getInterceptor() {
		
		return new AutenticacaoPorSessaoInterceptor();
		
		
	}
	
	// Para Interceptors
	
	/**
	 * Este método registra meus Interceptors no Spring
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(getInterceptor()).addPathPatterns("/**");	
		
	}
	
	// Para abrir views
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		//Registrar a configuração
		registry.viewResolver(resolver);
		
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
	}
	
}
