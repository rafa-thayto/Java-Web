package br.senai.sp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.senai.sp.config.ConnectionFactory;
import br.senai.sp.model.Usuario;

public class UsuarioDAO {

	// Atributo
	private Connection connection;

	public UsuarioDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public UsuarioDAO(Connection connection) {
		this.connection = connection;
	}

	public Usuario buscarUsuario(String user, String s) {
		try {
			
			// Cria um PreparedStatement
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM usuarios WHERE usuario = ? AND senha = ?");

			// Cria os parâmetros do PreparedStatement
			stmt.setString(1, user);
			stmt.setString(2, s);

			ResultSet rs =	stmt.executeQuery();
			
			if (rs.next()) {
				Usuario usuario = new Usuario();				
				usuario.setId(rs.getLong("id"));
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setSenha(rs.getString("senha"));
				return usuario;
			}
						
			rs.close();
			// Libera o recurso statement
			stmt.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);			
		}
		return null;

	}

}
