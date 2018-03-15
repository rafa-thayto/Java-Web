package br.senai.sp.info.pweb.livraria.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexoes {

	private Connection conexao;
	
	public void abrir() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		final String usuario = "root";
		final String senha = "root132";
		String sql = "jdbc:mysql://localhost:3306/livraria?serverTimezone=UTC&useSSL=true";
		
		conexao = DriverManager.getConnection(sql, usuario, senha);
		
	}
	
	public void fechar() {
		
		if(conexao != null) {
			
			try {
				
				conexao.close();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				
				
			} // fim try...catch
			
		}  // fim if
		
	} //fim fechar()
	
	public Connection getConexao() {
		
		return conexao;
		
	} // fim getConnection()
	
}
