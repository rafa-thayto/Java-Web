package br.com.senai.sp.informatica.ianespatrimonio.dao.jpa;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.senai.sp.informatica.ianespatrimonio.dao.CategoriaPatrimonioDAO;
import br.com.senai.sp.informatica.ianespatrimonio.model.CategoriaPatrimonio;

@Repository
@Transactional
public class CategoriaPatrimonioJPA implements CategoriaPatrimonioDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void persistir(CategoriaPatrimonio obj) {
		sessionFactory.getCurrentSession().persist(obj);
	}

	@Override
	public void deletar(CategoriaPatrimonio obj) {
		sessionFactory.getCurrentSession().delete(obj);
	}

	@Override
	public void alterar(CategoriaPatrimonio obj) {
		sessionFactory.getCurrentSession().update(obj);
	}

	@Override
	public CategoriaPatrimonio buscarId(Long id) {
		String hql = "FROM CategoriaPatrimonio cp WHERE cp.id = :id";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("id", id);
		
		List<CategoriaPatrimonio> result = query.list();
		
		if(!result.isEmpty()) {
			return result.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<CategoriaPatrimonio> buscarTodos() {
		String hql = "FROM CategoriaPatrimonio cp";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
}
