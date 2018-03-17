package br.senai.sp.info.pweb.livraria.dao.jdbc;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Repository;

import br.senai.sp.info.pweb.livraria.dao.DAO;
import br.senai.sp.info.pweb.livraria.models.Usuario;

@Repository
public class UsuarioDAO implements DAO<Usuario>{

	private FabricaDeConexoes fabrica;
	public UsuarioDAO() {
		fabrica = new FabricaDeConexoes();
	}
	
	@Override
	public Usuario buscar(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(Usuario obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(Usuario obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void persistir(Usuario obj) {

				
		try {
		
			fabrica.abrir();
			
			String sql = "INSERT INTO usuario SET "
					+ "nome = ?, sobrenome = ?, dt_nascimento = ?, email = ?, senha = ?";
			
			PreparedStatement stmt = fabrica.getConexao().prepareStatement(sql);
			stmt.setString(1, obj.getNome());
			stmt.setString(2, obj.getSobrenome());
			stmt.setDate(3, new Date(obj.getDataNascimento().getTime()) );
			stmt.setString(4, obj.getEmail());
			stmt.setString(5, obj.getSenha());
			
			stmt.execute();

			fabrica.fechar();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	public Usuario autenticar(Usuario usuario) {
		String sql = "SELECT id, nome, sobrenome, dt_nascimento FROM usuario WHERE email = ? AND senha = ?";
		
		try {
			
			fabrica.abrir();
			
			PreparedStatement stmt = fabrica.getConexao().prepareStatement(sql);
			
			stmt.setString(1, usuario.getEmail());
			stmt.setString(2, usuario.getSenha());
			
			ResultSet resultados = stmt.executeQuery();
			Usuario usuarioAutenticado = null;
			if (resultados.next()) {
				
				usuarioAutenticado = new Usuario();
				usuarioAutenticado.setId(resultados.getLong("id"));
				usuarioAutenticado.setDataNascimento(resultados.getDate("dt_nascimento"));
				usuarioAutenticado.setNome(resultados.getString("nome"));
				usuarioAutenticado.setSobrenome(resultados.getString("sobrenome"));
				usuarioAutenticado.setEmail(usuario.getEmail());
				usuarioAutenticado.setSenha(usuario.getSenha());
				
			}
			
			resultados.close();
			fabrica.fechar();
			
			return usuarioAutenticado;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
