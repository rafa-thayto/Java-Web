package br.com.senai.sp.informatica.ianespatrimonio.dao.jpa;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.senai.sp.informatica.ianespatrimonio.dao.UsuarioDAO;
import br.com.senai.sp.informatica.ianespatrimonio.model.Usuario;

@Repository
@Transactional
public class UsuarioJPA implements UsuarioDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void persistir(Usuario obj) {
		sessionFactory.getCurrentSession().persist(obj);
	}

	@Override
	public void deletar(Usuario obj) {
		sessionFactory.getCurrentSession().delete(obj);
	}

	@Override
	public void alterar(Usuario obj) {
		sessionFactory.getCurrentSession().update(obj);
	}

	@Override
	public Usuario buscarId(Long id) {
		String hql = "FROM Usuario u WHERE u.id = :id";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("id", id);
		
		List<Usuario> result = query.list();
		
		if(!result.isEmpty()) {
			return result.get(0);
		} else {
			return null;
		}
		
	}

	@Override
	public List<Usuario> buscarTodos() {
		
		String hql = "FROM Usuario u";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list(); 
		
	}

	@Override
	public Usuario buscarPorEmail(String email) {
		String hql = "FROM Usuario u WHERE u.email = :email";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setParameter("email", email);
		
		List<Usuario> result = query.list();
		
		if (!result.isEmpty()) {
			return result.get(0);
		} else {			
			return null;
		}
		
	}

	@Override
	public Usuario buscarPorEmailESenha(String email, String senha) {
		String hql = "FROM Usuario u WHERE u.email = :email AND u.senha = :senha";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		query.setParameter("email", email);
		query.setParameter("senha", senha);
		
		List<Usuario> result = query.list();
		
		if (!result.isEmpty()) {
			return result.get(0);
		} else {
			return null;
		}
		
	}

}
