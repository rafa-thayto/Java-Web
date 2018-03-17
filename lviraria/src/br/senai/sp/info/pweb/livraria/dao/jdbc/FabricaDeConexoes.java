package br.senai.sp.info.pweb.livraria.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexoes {

	private Connection conexao;
	
	public void abrir() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		final String USUARIO = "root";
		final String SENHA = "root132";
		
		String sql = "jdbc:mysql://localhost:3306/livraria?serverTimezone=UTC";
		conexao = DriverManager.getConnection(sql,USUARIO,SENHA);
	}
	
	public void fechar() {
		if(conexao != null) {
			try {
				conexao.close();
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public Connection getConexao() {
		return conexao;
	}
}
