package br.com.senai.sp.informatica.ianespatrimonio.dao.jpa;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.senai.sp.informatica.ianespatrimonio.dao.AmbienteDAO;
import br.com.senai.sp.informatica.ianespatrimonio.model.Ambiente;

@Repository
@Transactional
public class AmbienteJPA implements AmbienteDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void persistir(Ambiente obj) {
		sessionFactory.getCurrentSession().persist(obj);
	}

	@Override
	public void deletar(Ambiente obj) {
		sessionFactory.getCurrentSession().delete(obj);
	}

	@Override
	public void alterar(Ambiente obj) {
		sessionFactory.getCurrentSession().update(obj);
	}

	@Override
	public Ambiente buscarId(Long id) {
		String hql = "FROM Ambiente a WHERE a.id = :id";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("id", id);
		
		List<Ambiente> result = query.list();
		
		if(!result.isEmpty()) {
			return result.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<Ambiente> buscarTodos() {
		String hql = "FROM Ambiente a";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list(); 
	}

}
