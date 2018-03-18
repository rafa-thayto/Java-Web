package br.com.senai.sp.informatica.tecnow.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.senai.sp.informatica.tecnow.model.Anime;

@Repository
public class AnimeDAO implements DAO<Anime> {

	// Properties
	private ConnectionFactory connection;
	
	@Override
	public Anime search(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Anime> searchAll() {
		return null;
	}
	
	@Override
	public List<Anime> searchAllBy(Anime obj) {
		String sql = "SELECT * FROM anime WHERE id = ?";
		
		List<Anime> animeList = new ArrayList<>();
		try {
			this.connection.open();
			
			PreparedStatement stmt = this.connection.getConnection().prepareStatement(sql);
			stmt.setLong(1, obj.getId());
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Anime anime = new Anime();
				anime.setId(rs.getLong("id"));
				anime.setName(rs.getString("nome"));
				anime.setRegisterDate(rs.getDate("data_cadastro"));
				
				// Adiciona anime na lista
				animeList.add(anime);
			}
			rs.close();
			
			return animeList;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			this.connection.close();
		}
	}

	@Override
	public void insert(Anime obj) {
		String sql = "INSERT INTO anime SET nome = ?, data_cadastro = ?";
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
	public void remove(Anime obj) {
		String sql = "DELETE FROM anime WHERE id = ?";
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
	public void change(Anime obj) {
		String sql = "UPDATE anime SET nome = ? WHERE id = ?";
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
