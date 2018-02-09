package br.senai.sp.informatica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.senai.sp.informatica.config.ConnectionFactory;
import br.senai.sp.informatica.model.Game;

public class GameDAO {
	private Connection connection;
	
	public GameDAO() {
		connection = new ConnectionFactory().getConnection();
	}
	
	public void save(Game game) {
		String sql = null;
		
		if(game.getId() != null) {
			// Update
			sql = "UPDATE games SET name = ?, dev = ? WHERE id = ?";
		} else {
			// Insert
			sql = "INSER INTO games (name, dev) VALUES (?, ?)";
		}
		
		// Create a sql command
		try {
			// PreparedStatement
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			// PreparedStatement Parameters
			stmt.setString(1, game.getName());
			stmt.setString(2, game.getDev());
			
			// Execute insert
			stmt.execute();
			// Close
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
	//getList
	public List<Game> getList() {
		try {
			// Create a arraylist
			List<Game> games = new ArrayList<>();
			
			// PreparedStatement
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM games");
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Game game = new Game();
				game.setId(rs.getLong("id"));
				game.setName(rs.getString("name"));
				game.setDev(rs.getString("dev"));
				
				games.add(game);
			}
			
			// Close resultSet
			rs.close();
			
			// Close statement
			stmt.close();
			
			// return list games
			return games;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public void delete(Game game) {
		try {
			PreparedStatement stmt = connection.prepareStatement("DELETE FROM games WHERE id = ?");
			stmt.setLong(1, game.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

