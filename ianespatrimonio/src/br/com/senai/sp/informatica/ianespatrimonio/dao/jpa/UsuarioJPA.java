package br.com.senai.sp.informatica.ianespatrimonio.dao.jpa;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.senai.sp.informatica.ianespatrimonio.dao.UsuarioDAO;
import br.com.senai.sp.informatica.ianespatrimonio.models.Usuario;

@Repository
public class UsuarioJPA implements UsuarioDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void persistir(Usuario obj) {
		sessionFactory.getCurrentSession().persist(obj);
	}

	@Override
	public void deletar(Usuario obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Usuario obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buscarId(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Usuario> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
