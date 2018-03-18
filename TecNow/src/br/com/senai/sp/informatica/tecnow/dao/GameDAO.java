package br.com.senai.sp.informatica.tecnow.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.senai.sp.informatica.tecnow.model.Game;

@Repository
public class GameDAO implements DAO<Game>{
	
	// Properties
	private ConnectionFactory connection;
	
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
		String sql = "SELECT * FROM jogo WHERE id = ?"; // TODO: categoria
		
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
//				game.setCategory(rs.);
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
		// TODO: Fix categoria
		String sql = "INSERT INTO jogos SET nome = ?, data_cadastro = ?"; //, categoria = ?
		try {
			this.connection.open();
			
			PreparedStatement stmt = this.connection.getConnection().prepareStatement(sql);
			stmt.setString(1, obj.getName());
			stmt.setDate(2, new Date(obj.getRegisterDate().getTime()));
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
		String sql = "UPDATE jogo SET nome = ? WHERE id = ?"; // TODO: categoria = ?
		try {
			this.connection.open();
			
			PreparedStatement stmt = this.connection.getConnection().prepareStatement(sql);
			stmt.setString(1, obj.getName());
			stmt.setLong(2, obj.getId());
			stmt.execute();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			this.connection.close();
		}
	}

}
