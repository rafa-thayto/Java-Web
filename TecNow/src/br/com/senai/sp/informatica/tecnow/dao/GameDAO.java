package br.com.senai.sp.informatica.tecnow.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.senai.sp.informatica.tecnow.model.Game;

@Repository
public class GameDAO implements DAO<Game>{

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
	public void insert(Game obj) {
		// TODO: Fix categoria
		String sql = "INSERT INTO jogos SET nome = ?, data_cadastro = ?"; //, categoria = ?
		try {
			connection.open();
			
			PreparedStatement stmt = connection.getConnection().prepareStatement(sql);
			stmt.setString(1, obj.getName());
			stmt.setDate(2, new Date(obj.getRegisterDate().getTime()));
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			connection.close();
		}
	}

	@Override
	public void remove(Game obj) {
		String sql = "";
		try {
			connection.open();
			
			PreparedStatement stmt = connection.getConnection().prepareStatement(sql);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			connection.close();
		}
	}

	@Override
	public void change(Game obj) {
		String sql = "";
		try {
			connection.open();
			
			PreparedStatement stmt = connection.getConnection().prepareStatement(sql);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			connection.close();
		}
	}

}
