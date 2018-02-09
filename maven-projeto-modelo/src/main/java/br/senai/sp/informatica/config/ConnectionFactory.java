package br.senai.sp.informatica.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/dblivros?autoReconnect=true&useSSL=false",
					"root", "root132");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
			throw new RuntimeException(e);
		}
	}
	
}
