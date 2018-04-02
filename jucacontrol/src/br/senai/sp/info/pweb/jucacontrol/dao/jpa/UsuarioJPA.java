package br.senai.sp.info.pweb.jucacontrol.dao.jpa;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.senai.sp.info.pweb.jucacontrol.dao.UsuarioDAO;
import br.senai.sp.info.pweb.jucacontrol.models.Usuario;

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
	public List<Usuario> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletar(Usuario obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario buscarId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(Long id) {
		// TODO Auto-generated method stub
		
	}

}
