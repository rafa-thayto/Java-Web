package br.senai.sp.info.pweb.jucacontrol.dao;

import java.util.List;

import br.senai.sp.info.pweb.jucacontrol.models.Usuario;

public interface UsuarioDAO {
	
	public void persistir(Usuario obh);
	public List<Usuario> buscarTodos();
	public void deletar(Usuario obj);
	public Usuario buscarId(Long id);
	public void alterar(Long id);
	
}
