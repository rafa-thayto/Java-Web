package br.com.senai.sp.informatica.ianespatrimonio.jobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;import com.sun.xml.internal.bind.CycleRecoverable.Context;

import br.com.senai.sp.informatica.ianespatrimonio.dao.UsuarioDAO;
import br.com.senai.sp.informatica.ianespatrimonio.models.Usuario;

@Component
public class CriarAdministradorJob implements ApplicationListener<ContextRefreshedEvent> {
	
	
	@Autowired
	private UsuarioDAO usuarioDAO;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// Criando o administrador padrão
		Usuario admin = new Usuario();
		admin.setNome("Administrador");
		admin.setSobrenome("do sistema");
		admin.setEmail("admin@email.com");
		admin.setSenha("admin");
		admin.hashearSenha();
		
		usuarioDAO.persistir(admin);
		System.out.println(admin);
	}
	
	
}
