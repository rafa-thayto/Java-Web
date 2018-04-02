package br.senai.sp.info.pweb.jucacontrol.jobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.senai.sp.info.pweb.jucacontrol.dao.UsuarioDAO;
import br.senai.sp.info.pweb.jucacontrol.dao.jpa.UsuarioJPA;
import br.senai.sp.info.pweb.jucacontrol.models.TiposUsuario;
import br.senai.sp.info.pweb.jucacontrol.models.Usuario;

@Component
public class CriarAdministradorJob implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private UsuarioDAO usuarioJPA; 
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("Job de inicialização disparatado");
		
		// Criando objetos do usuário administrador padrão
		Usuario admin = new Usuario();
		admin.setEmail("admin@email.com");
		admin.setNome("Administrador");
		admin.setSobrenome("do sistema");
		admin.setSenha("admin");
		admin.setTipo(TiposUsuario.ADMINISTRADOR);
		admin.hashearSenha();
		
		System.out.println();
		usuarioJPA.persistir(admin);
		System.out.println();
	}

}
