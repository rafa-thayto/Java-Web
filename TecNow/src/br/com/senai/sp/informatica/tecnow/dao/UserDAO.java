package br.com.senai.sp.informatica.tecnow.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.senai.sp.informatica.tecnow.model.User;
import br.com.senai.sp.informatica.tecnow.utils.Gender;

@Repository
public class UserDAO implements DAO<User> {

	// Properties
	private ConnectionFactory connection;
	
	/**
	 * This method authenticates user in the session
	 * @param user
	 * @return
	 */
	public User auth(User user) {
		String sql = "SELECT * WHERE id = ? and senha = ?";
		try {
			this.connection.open();
			
			PreparedStatement stmt = this.connection.getConnection().prepareStatement(sql);
			stmt.setLong(1, user.getId());
			
			ResultSet rs = stmt.executeQuery();
			User authUser = null;
			
			if (rs.next()) {
				authUser = new User();
				// Pegando dados do usuario
				authUser.setId(rs.getLong("id"));
				authUser.setName(rs.getString("nome"));
				authUser.setEmail(rs.getString("email"));
				authUser.setPassword(rs.getString("email"));
				authUser.setBirthDate(rs.getDate("data_nascimento"));
				authUser.setGender(Gender.valueOf(rs.getString("genero")));
				
				authUser.setEmail(user.getEmail());
				authUser.setPassword(user.getPassword());
			}
			rs.close();
			
			return authUser;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			this.connection.close();
		}
		
		return user;
	}
	
	@Override
	public User search(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> searchAll() {
		String sql = "SELECT * FROM usuario";
		List<User> userList = new ArrayList<>();
		
		try {
			this.connection.open();
			
			PreparedStatement stmt = this.connection.getConnection().prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getLong("id"));
				user.setName(rs.getString("nome"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("senha"));
				user.setBirthDate(rs.getDate("data_nascimento"));
				user.setGender(Gender.valueOf(rs.getString("genero")));
				
				userList.add(user);
			}
			
			return userList;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			this.connection.close();
		}
		
	}
	
	@Override
	public List<User> searchAllBy(User obj) {
		String sql = "SELECT * FROM usuario WHERE id = ?";
		List<User> userList = new ArrayList<>(); 
		
		try {
			this.connection.open();
			PreparedStatement stmt = this.connection.getConnection().prepareStatement(sql);
			stmt.setLong(1, obj.getId());
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getLong("id"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("senha"));
//				user.setGender(gender);
				user.setBirthDate(rs.getDate("data_nascimento"));
				
				userList.add(user);
			}
			rs.close();
			return userList;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			this.connection.close();
		}
	}

	@Override
	public void insert(User obj) {
		String sql = "INSERT INTO usuario SET nome = ?, email = ?, senha = ?, data_nascimento = ?, genero = ?"; 
		try {
			// Criando uma conexao com o banco de dados
			this.connection.open();
			
			PreparedStatement stmt = this.connection.getConnection().prepareStatement(sql);
			stmt.setString(1, obj.getName());
			stmt.setString(2, obj.getEmail());
			stmt.setString(3, obj.getPassword());
			stmt.setDate(4, new Date(obj.getBirthDate().getTime()));
			stmt.setString(5, obj.getGender().toString());
			stmt.execute();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			this.connection.close();
		}
	}

	@Override
	public void remove(User obj) {
		String sql = "DELETE FROM usuario WHERE id = ?";
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
	public void change(User obj) {
		String sql = "UPDATE usuario SET nome = ?, email = ?, senha = ?, data_nascimento = ?, genero = ? WHERE id = ?";
		try {
			this.connection.open();
			
			PreparedStatement stmt = this.connection.getConnection().prepareStatement(sql);
			stmt.setString(1, obj.getName());
			stmt.setString(2, obj.getEmail());
			stmt.setString(3, obj.getPassword());
			stmt.setDate(4, new Date(obj.getBirthDate().getTime()));
			stmt.setString(5, obj.getGender().toString());
			stmt.setLong(6, obj.getId());
			stmt.execute();

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			this.connection.close();
		}
	}

}
