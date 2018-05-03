package br.com.senai.sp.informatica.ianespatrimonio.dao;

import br.com.senai.sp.informatica.ianespatrimonio.model.Usuario;

public interface UsuarioDAO extends DAO<Usuario> {
	
	public Usuario buscarPorEmail(String email);
	public Usuario buscarPorEmailESenha(String email, String senha);
}
