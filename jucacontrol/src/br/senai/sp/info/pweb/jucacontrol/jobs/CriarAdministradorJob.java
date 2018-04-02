package br.senai.sp.info.pweb.jucacontrol.jobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.senai.sp.info.pweb.jucacontrol.dao.UsuarioDAO;
import br.senai.sp.info.pweb.jucacontrol.models.TiposUsuario;
import br.senai.sp.info.pweb.jucacontrol.models.Usuario;

@Component
public class CriarAdministradorJob implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private UsuarioDAO usuarioDAO; 
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("Job de inicializa��o disparatado");
		
		// Criando objetos do usu�rio administrador padr�o
		Usuario admin = new Usuario();
		admin.setEmail("admin@email.com");
		admin.setNome("Administrador");
		admin.setSobrenome("do sistema");
		admin.setSenha("admin");
		admin.setTipo(TiposUsuario.ADMINISTRADOR);
		admin.hashearSenha();
		
		System.out.println("[JOB]: Verificando exist�ncia no usu�rio administrador...");
		if (usuarioDAO.buscarPorEmail(admin.getEmail()) == null) {
			System.out.println("[JOB]: Criando usu�rio administrador...");
			usuarioDAO.persistir(admin);
		} else {
			System.out.println("[JOB]: Administrador j� existe.");
		}
		System.out.println("[JOB]: Usu�rio administrador pronto para uso.");
	}

}
