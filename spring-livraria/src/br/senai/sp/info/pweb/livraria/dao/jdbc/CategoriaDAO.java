package br.senai.sp.info.pweb.livraria.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.senai.sp.info.pweb.livraria.dao.DAO;
import br.senai.sp.info.pweb.livraria.models.Categoria;
import br.senai.sp.info.pweb.livraria.models.Usuario;

@Repository
public class CategoriaDAO implements DAO<Categoria> {

	private FabricaDeConexoes conexao;

	public CategoriaDAO() {

		conexao = new FabricaDeConexoes();

	}

	@Override
	public Categoria buscar(Long id) {

		String sql = "SELECT id, nome FROM categoria WHERE id = ?";

		try {

			this.conexao.abrir();

			// Cria o stmt
			PreparedStatement statement = conexao.getConexao().prepareStatement(sql);

			// Passa o id do usuário para filtrar as categorias
			statement.setLong(1, id);

			// Executa a busca
			ResultSet rs = statement.executeQuery();
			
			Categoria categoria = null;

			if (rs.next()) {

				categoria = new Categoria();
				categoria.setId(rs.getLong("id"));
				categoria.setNome(rs.getString("nome"));
				
			}

			rs.close();

			return categoria;

		} catch (Exception e) {

			// Lança o erro para cima, fazendo a classe que chamae este método tratar o erro
			throw new RuntimeException(e);

		}

		// Colocamos o fechar conexão no finnaly pois ela deve ser encerrada tanto
		// se der erro 'catch' ou se der tudo certo :-)!

		finally {

			this.conexao.fechar();

		}
	}

	@Override
	public List<Categoria> buscarTodos() {

		return null;
	}

	// Buscar todos que filtra a categoria por usuário

	/**
	 * Busca as categorias de um usuário especifico
	 * 
	 * @param usuario
	 *            - O usuário que será utilizado no filtro de busca
	 * @return
	 */
	public List<Categoria> buscarTodos(Usuario usuario) {

		String sql = "SELECT id, nome FROM categoria WHERE usuario_id = ?";

		List<Categoria> listaCategorias = new ArrayList<>(100);

		try {

			this.conexao.abrir();

			// Cria o stmt
			PreparedStatement statement = conexao.getConexao().prepareStatement(sql);

			// Passa o id do usuário para filtrar as categorias
			statement.setLong(1, usuario.getId());

			// Executa a busca
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Categoria categoria = new Categoria();

				categoria.setId(rs.getLong("id"));
				categoria.setNome(rs.getString("nome"));

				// Adiciona a categoria na lista
				listaCategorias.add(categoria);

			}

			rs.close();

			return listaCategorias;

		} catch (Exception e) {

			// Lança o erro para cima, fazendo a classe que chamae este método tratar o erro
			throw new RuntimeException(e);

		}

		// Colocamos o fechar conexão no finnaly pois ela deve ser encerrada tanto
		// se der erro 'catch' ou se der tudo certo :-)!

		finally {

			this.conexao.fechar();

		}
	}

	@Override
	public void alterar(Categoria obj) {

	}

	@Override
	public void deletar(Categoria obj) {

		String sql = "DELETE FROM categoria WHERE id=?";

		try {

			conexao.abrir();

			PreparedStatement stmt = conexao.getConexao().prepareStatement(sql);

			// Aplica o id
			stmt.setLong(1, obj.getId());
			stmt.execute();

		} catch (Exception e) {

			throw new RuntimeException(e);

		} finally {

			conexao.fechar();

		}

	}

	@Override
	public void persistir(Categoria obj) {

		String sql = "INSERT INTO categoria SET nome = ?, usuario_id = ?";

		try {

			conexao.abrir();

			PreparedStatement stmt = conexao.getConexao().prepareStatement(sql);

			stmt.setString(1, obj.getNome());
			stmt.setLong(2, obj.getUsuario().getId());

			stmt.execute();

		} catch (Exception e) {

			throw new RuntimeException(e);

		} finally {

			conexao.fechar();

		}

	}

}
