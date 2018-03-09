package br.com.senai.sp.informatica.mercadofamilia.dao;

import java.sql.PreparedStatement;
import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.senai.sp.informatica.mercadofamilia.models.Usuario;

@Repository
public class UsuarioDAO implements DAO<Usuario> {

	private ConnectionFactory connectionFactory;
	
	public UsuarioDAO() {
		connectionFactory = new ConnectionFactory();
	}
	
	@Override
	public Usuario buscar(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserir(Usuario obj) {
		String sql = "INSERT INTO usuario SET nome = ?, dataNascimento = ?, senha = ?";
		
		try {
			PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
			stmt.setString(1, obj.getNome());
			stmt.setDate(2, new Date(obj.getDataNascimento().getTime()));
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void deletar(Usuario obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Usuario obj) {
		// TODO Auto-generated method stub
		
	}

}
