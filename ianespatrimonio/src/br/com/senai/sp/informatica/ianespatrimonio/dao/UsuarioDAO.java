package br.com.senai.sp.informatica.ianespatrimonio.dao;

import java.util.List;

import br.com.senai.sp.informatica.ianespatrimonio.models.Usuario;

public interface UsuarioDAO {

	public void persistir(Usuario obj);
	public void deletar(Usuario obj);
	public void alterar(Usuario obj);
	public void buscarId(Long id);
	public List<Usuario> buscarTodos();
	
}
