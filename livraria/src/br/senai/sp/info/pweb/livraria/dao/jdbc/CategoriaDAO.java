package br.senai.sp.info.pweb.livraria.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.senai.sp.info.pweb.livraria.dao.DAO;
import br.senai.sp.info.pweb.livraria.models.Categoria;
import br.senai.sp.info.pweb.livraria.models.Usuario;

@Repository
public class CategoriaDAO implements DAO<Categoria> {
	
	private ConnectionFactory connectionFactory;
	
	public CategoriaDAO() {
		connectionFactory = new ConnectionFactory();
	}

	@Override
	public Categoria search(Long id) {
		String sql = "SELECT nome FROM categoria WHERE id = ?";
		try {
			connectionFactory.open();
			
			PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
			
			stmt.setLong(1, id);

			// Realiza a busca de usu�rios
			ResultSet resultados = stmt.executeQuery();
			Categoria c = new Categoria();
			if (resultados.next()) {
				c.setId(id);
				c.setNome(resultados.getString("nome"));
			}
			// Fecha o resultSet e retorna a lista com os dados
			resultados.close();
			return c;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			connectionFactory.close();			
		}
	}

	@Override
	public List<Categoria> searchAll() {
		return null;
	}
	
	public List<Categoria> searchAllByUser(Usuario usuario) {
		String sql = "SELECT id, nome FROM categoria WHERE usuario_id = ?";
		List<Categoria> listaCategorias = new ArrayList<>(100);
		
		try {
			connectionFactory.open();
			
			PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
			
			stmt.setLong(1, usuario.getId());

			// Realiza a busca de usu�rios
			ResultSet resultados = stmt.executeQuery();
			while (resultados.next()) {
				Categoria c = new Categoria();
				c.setId(resultados.getLong("id"));
				c.setNome(resultados.getString("nome"));
				listaCategorias.add(c);
			}
			// Fecha o resultSet e retorna a lista com os dados
			resultados.close();
			return listaCategorias;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			connectionFactory.close();			
		}

	}

	@Override
	public void change(Categoria obj) {
		String sql = "UPDATE categoria SET nome = ? WHERE id = ?";
		
		try {
			connectionFactory.open();
			
			PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
			
			stmt.setString(1, obj.getNome());
			stmt.setLong(2, obj.getId());
			
			stmt.execute();
		} catch(Exception e) {
			throw new RuntimeException(e);
		} finally {
			connectionFactory.close();			
		}
	}

	@Override
	public void delete(Categoria obj) {
		String sql = "DELETE FROM categoria WHERE id = ?";
		
		try {
			connectionFactory.open();
			PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
			stmt.setLong(1, obj.getId());
			stmt.execute();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			connectionFactory.close();
		}
	}

	@Override
	public void persistence(Categoria obj) {
		String sql = "INSERT INTO categoria SET usuario_id = ?, nome = ?";
		
		try {
			connectionFactory.open();
			
			PreparedStatement stmt = connectionFactory.getConnection().prepareStatement(sql);
			
			stmt.setLong(1, obj.getUsuario().getId());
			stmt.setString(2, obj.getNome());
			
			stmt.execute();
		} catch(Exception e) {
			throw new RuntimeException(e);
		} finally {
			connectionFactory.close();			
		}
	}

}
