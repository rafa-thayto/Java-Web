package br.com.senai.sp.informatica.tecnow.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.senai.sp.informatica.tecnow.model.Game;
import br.com.senai.sp.informatica.tecnow.utils.Category;

@Repository
public class GameDAO implements DAO<Game>{
	
	// Properties
	private ConnectionFactory connection;
	
	//Constructor
	public GameDAO() {
		this.connection = new ConnectionFactory();
	}
	
	@Override
	public Game search(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Game> searchAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Game> searchAllBy(Game obj) {
		String sql = "SELECT * FROM jogo WHERE id = ?";
		
		List<Game> gameList = new ArrayList<>();
		try {
			this.connection.open();
			
			PreparedStatement stmt = this.connection.getConnection().prepareStatement(sql);
			stmt.setLong(1, obj.getId());
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Game game = new Game();
				game.setId(rs.getLong("id"));
				game.setName(rs.getString("nome"));
				game.setCategory(Category.valueOf(rs.getString("categoria")));
				game.setRegisterDate(rs.getDate("data_cadastro"));
				
				gameList.add(game);
			}
			rs.close();
			return gameList;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			this.connection.close();
		}
	}

	@Override
	public void insert(Game obj) {
		String sql = "INSERT INTO jogo SET nome = ?, data_cadastro = ?, categoria = ?";
		try {
			this.connection.open();
			
			PreparedStatement stmt = this.connection.getConnection().prepareStatement(sql);
			stmt.setString(1, obj.getName());
			stmt.setDate(2, new Date(obj.getRegisterDate().getTime()));
			stmt.setString(3, obj.getCategory().getDescription());
			stmt.execute();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			this.connection.close();
		}
	}

	@Override
	public void remove(Game obj) {
		String sql = "DELETE FROM jogo WHERE id = ?";
		try {
			this.connection.open();
			
			PreparedStatement stmt = this.connection.getConnection().prepareStatement(sql);
			stmt.setLong(1, obj.getId());
			stmt.execute();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			this.connection.close();
		}
	}

	@Override
	public void change(Game obj) {
		String sql = "UPDATE jogo SET nome = ?, categoria = ? WHERE id = ?"; 
		try {
			this.connection.open();
			
			PreparedStatement stmt = this.connection.getConnection().prepareStatement(sql);
			stmt.setString(1, obj.getName());
			stmt.setString(2, obj.getCategory().getDescription());
			stmt.setLong(3, obj.getId());
			stmt.execute();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			this.connection.close();
		}
	}

}
