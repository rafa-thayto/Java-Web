package br.com.senai.sp.informatica.tecnow.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import br.com.senai.sp.informatica.tecnow.interceptors.AuthenticationSessionInterceptor;

@EnableWebMvc
@Configuration
@ComponentScan("br.com.senai.sp.informatica.tecnow")
public class WebConfig implements WebMvcConfigurer {
	
	// Injects the interceptor
	@Autowired
	private AuthenticationSessionInterceptor interceptor;
	
	// Register all interceptors
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor).addPathPatterns("/**");
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		registry.viewResolver(resolver);
	}
	
	
}
