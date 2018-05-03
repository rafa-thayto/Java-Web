package br.com.senai.sp.informatica.ianespatrimonio.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;import com.sun.xml.internal.bind.CycleRecoverable.Context;

import br.com.senai.sp.informatica.ianespatrimonio.dao.UsuarioDAO;
import br.com.senai.sp.informatica.ianespatrimonio.model.TiposUsuario;
import br.com.senai.sp.informatica.ianespatrimonio.model.Usuario;

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
		admin.setSenha("admin@132");
		admin.setTipo(TiposUsuario.ADMINISTRADOR);
		admin.hashearSenha();
		
		System.out.println("Verificando se o administrador existe...");
		if (usuarioDAO.buscarPorEmail(admin.getEmail()) == null) {
			System.out.println("Cadastrando usuário administrador em ... Já foi!");
			usuarioDAO.persistir(admin);
		} else {
			System.out.println("O usuario já existe, voltemos a programação normal");
		}
		System.out.println(admin);
	}
	
	
}
