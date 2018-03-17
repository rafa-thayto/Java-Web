package br.com.senai.sp.informatica.tecnow.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.senai.sp.informatica.tecnow.model.Anime;

@Repository
public class AnimeDAO implements DAO<Anime> {

	private ConnectionFactory connection;
	
	@Override
	public Anime search(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Anime> searchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Anime obj) {
		String sql = "INSERT INTO anime SET nome = ?, data_cadastro = ?";
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
	public void remove(Anime obj) {
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
	public void change(Anime obj) {
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
