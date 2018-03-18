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
public class CategoriaDAO implements DAO<Categoria>{

	private FabricaDeConexoes fabrica;
	public CategoriaDAO() {
		fabrica = new FabricaDeConexoes();
	}
	
	@Override
	public Categoria buscar(Long id) {
	String sql = "SELECT nome FROM categoria WHERE id = ?";
		
		try {
			fabrica.abrir();
			
			PreparedStatement stmt = fabrica.getConexao().prepareStatement(sql);
			
			//Adiciona o parametro do filtro do usuario
			stmt.setLong(1, id);
			
			//Realiza a busca de usuarios
			ResultSet resultados = stmt.executeQuery();
			
			
			Categoria c = new Categoria();
			
			if(resultados.next()) {
							
				c.setId(id);
				c.setNome(resultados.getString("nome"));
							
			}
			
			//Fecha o resultSet
			resultados.close();
			return c;
			
		} catch (Exception e) {
			
		//finally ---> cláusula que é disparada quando der exception ou não
		}finally {
			//Colocamos o fechamento da conexão aqui para garantir que sempre seha encerrada
			fabrica.fechar();
		}
		
		return null;
	}

	@Override
	public List<Categoria> buscarTodos() {

		return null;
	}
	
	public List<Categoria> buscarTodosPorUsuario(Usuario usuario) {
		
		String sql = "SELECT id, nome FROM categoria WHERE usuario_id = ?";
		
		//Lista para armazenar os resultados
		List<Categoria> listaCategorias = new ArrayList<>(100);
		
		try {
			fabrica.abrir();
			
			PreparedStatement stmt = fabrica.getConexao().prepareStatement(sql);
			
			//Adiciona o parametro do filtro do usuario
			stmt.setLong(1, usuario.getId());
			
			//Realiza a busca de usuarios
			ResultSet resultados = stmt.executeQuery();
			
			while(resultados.next()) {
				//cria o objeto para guardar os dados da linha
				Categoria c = new Categoria();
				c.setId(resultados.getLong("id"));
				c.setNome(resultados.getString("nome"));
				
				//guardar na lista
				listaCategorias.add(c);
			}
			
			//Fecha o resultSet
			resultados.close();
			return listaCategorias;
			
		} catch (Exception e) {
			
		//finally ---> cláusula que é disparada quando der exception ou não
		}finally {
			//Colocamos o fechamento da conexão aqui para garantir que sempre seha encerrada
			fabrica.fechar();
		}
		
		return null;
	}


	@Override
	public void alterar(Categoria obj) {
		try {
			
			fabrica.abrir();
			
			String sql = "Update categoria SET nome = ? Where id = ?";
			
			PreparedStatement stmt = fabrica.getConexao().prepareStatement(sql);
			
			stmt.setString(1, obj.getNome());
			stmt.setLong(2, obj.getId());		
			stmt.execute();

			fabrica.fechar();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

		
	
	

	@Override
	public void deletar(Categoria obj) {
		String sql = "DELETE FROM categoria WHERE id = ?";
		
		try {
			fabrica.abrir();
			
			PreparedStatement stmt = fabrica.getConexao().prepareStatement(sql);
			
			// adicionando parametros
			stmt.setLong(1, obj.getId());
			
			stmt.execute();
			
		} catch (Exception e) {
			throw new RuntimeException();
		}finally {
			fabrica.fechar();
		}
	}

	@Override
	public void persistir(Categoria obj) {

				
		try {
		
			fabrica.abrir();
			
			String sql = "INSERT INTO categoria SET usuario_id = ?, nome = ?";
			
			PreparedStatement stmt = fabrica.getConexao().prepareStatement(sql);
			
			stmt.setLong(1, obj.getUsuario().getId());
			stmt.setString(2, obj.getNome());
					
			stmt.execute();

			fabrica.fechar();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}



}
