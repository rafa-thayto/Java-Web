package br.senai.sp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.senai.sp.config.ConnectionFactory;
import br.senai.sp.model.Livro;

public class LivroDAO {

	// Atributo
	private Connection connection;

	// Construtor
	public LivroDAO() {
		// Estabelece uma conexao com o banco de dados
		connection = new ConnectionFactory().getConnection();
	}

	// Salva
	public void salva(Livro livro) {
		String sql = null;

		// Se o livro não tem um id
		if (livro.getId() != null) {
			// Faça um update
			sql = "UPDATE livros SET nome = ?, autor = ? WHERE id = ?";
		} else {
			// Faça um insert
			sql = "INSERT INTO livros (nome, autor) " + "VALUES (?, ?)";
		}

		// Cria um comando sql
		try {

			// Cria um PreparedStatement
			PreparedStatement stmt = connection.prepareStatement(sql);

			// Cria os parâmetros do PreparedStatement
			stmt.setString(1, livro.getNome());
			stmt.setString(2, livro.getAutor());
			
			if (livro.getId() != null) {
				stmt.setLong(3, livro.getId());
			}

			// Executa o insert
			stmt.execute();
			// Libera o recurso statement
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	// getLista
	public List<Livro> getLista() {

		try {
			// Cria um arrayList
			List<Livro> livros = new ArrayList<>();

			// Cria um PreparedStatement
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM livros");

			// Executa o statement e guarda o resultado em um ResultSet
			ResultSet rs = stmt.executeQuery();

			// Enquanto houver dados no resultSet
			while (rs.next()) {
				// Cria um livro com os dados do resultSet
				Livro livro = new Livro();
				livro.setId(rs.getLong("id"));
				livro.setNome(rs.getString("nome"));
				livro.setAutor(rs.getString("autor"));
				
				// Adiciona o livro à lista de contatos
				livros.add(livro);
			} // Fim do while

			// Fecha o ResultSet
			rs.close();

			// Fecha o statement
			stmt.close();

			// retorna a lista de livro
			return livros;
		} catch (SQLException e) {
			throw new RuntimeException();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public void excluir(Livro livro) {
		try {
			PreparedStatement stmt = connection.prepareStatement("DELETE FROM livros WHERE id = ?");
			stmt.setLong(1, livro.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}