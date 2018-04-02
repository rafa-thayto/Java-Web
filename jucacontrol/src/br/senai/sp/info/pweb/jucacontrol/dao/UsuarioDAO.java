package br.senai.sp.info.pweb.jucacontrol.dao;

import java.util.List;

import br.senai.sp.info.pweb.jucacontrol.models.Usuario;

public interface UsuarioDAO {
	
	public Usuario persistir(Usuario usuario);
	public List<Usuario> buscarTodos();
	public void deletar(Long id);
	public Usuario buscarId(Long id);
	public void alterar(Long id);
	
}
