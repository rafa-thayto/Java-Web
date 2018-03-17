package br.senai.sp.info.pweb.livraria.dao.jdbc;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.senai.sp.info.pweb.livraria.dao.DAO;
import br.senai.sp.info.pweb.livraria.models.Usuario;

@Repository
public class UsuarioDAO implements DAO<Usuario> {
	
	private ConnectionFactory connectionFactory;
	
	public UsuarioDAO() {
		connectionFactory = new ConnectionFactory();
	}

	@Override
	public Usuario search(Long id) {
		return null;
	}

	@Override
	public List<Usuario> searchAll() {
		return null;
	}

	@Override
	public void change(Usuario obj) {
		
	}

	@Override
	public void delete(Usuario obj) {
		
	}

	@Override
	public void persistence(Usuario obj) {
		String sql = "INSERT INTO usuario SET nome = ?, sobrenome = ?, dt_nascimento = ?, email = ?, senha = ?";
		
		try {
			connectionFactory.open();
			
			PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
			
			stmt.setString(1, obj.getNome());
			stmt.setString(2, obj.getSobrenome());
			stmt.setDate(3, new Date(obj.getDataNascimento().getTime()));
			stmt.setString(4, obj.getEmail());
			stmt.setString(5, obj.getSenha());
			stmt.execute();
			connectionFactory.close();
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Usuario auth(Usuario usuario) {
		String sql = "SELECT id, nome, sobrenome, dt_nascimento FROM usuario WHERE email = ? AND senha = ?";
		
		try {
			connectionFactory.open();
			PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
			stmt.setString(1,  usuario.getEmail());
			stmt.setString(2, usuario.getSenha());
			
			ResultSet resultSet = stmt.executeQuery();
			Usuario usuarioAutenticado = null;
			
			if (resultSet.next()) {
				usuarioAutenticado = new Usuario();
				usuarioAutenticado.setId(resultSet.getLong("id"));
				usuarioAutenticado.setDataNascimento(resultSet.getDate("dt_nascimento"));
				usuarioAutenticado.setNome(resultSet.getString("nome"));
				usuarioAutenticado.setSobrenome(resultSet.getString("sobrenome"));
				usuarioAutenticado.setEmail(usuario.getEmail());
				usuarioAutenticado.setSenha(usuario.getSenha());
			}
			
			resultSet.close();
			connectionFactory.close();
			return usuarioAutenticado;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
