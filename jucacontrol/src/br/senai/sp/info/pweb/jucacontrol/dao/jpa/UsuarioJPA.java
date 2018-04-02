package br.senai.sp.info.pweb.jucacontrol.dao.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.senai.sp.info.pweb.jucacontrol.dao.UsuarioDAO;
import br.senai.sp.info.pweb.jucacontrol.models.Usuario;

@Repository
public class UsuarioJPA implements UsuarioDAO {

	@Override
	public Usuario persistir(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletar(Long id) {
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
