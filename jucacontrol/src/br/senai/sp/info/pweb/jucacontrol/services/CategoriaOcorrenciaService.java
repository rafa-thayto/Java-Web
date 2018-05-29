package br.senai.sp.info.pweb.jucacontrol.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import br.senai.sp.info.pweb.jucacontrol.dao.CategoriaOcorrenciaDAO;
import br.senai.sp.info.pweb.jucacontrol.exceptions.EntidadeNaoEncontradaException;
import br.senai.sp.info.pweb.jucacontrol.exceptions.ValidacaoException;
import br.senai.sp.info.pweb.jucacontrol.models.CategoriaOcorrencia;

@Service
public class CategoriaOcorrenciaService {
	
	@Autowired
	private CategoriaOcorrenciaDAO categoriaDao;
	
	public void deletarPorId(Long id) throws EntidadeNaoEncontradaException {
		categoriaDao.deletar(buscar(id));
	}
	
	public CategoriaOcorrencia alterar(Long id
			, CategoriaOcorrencia categoriaOcorrencia
			, BindingResult bindingResult) throws ValidacaoException, EntidadeNaoEncontradaException {

		if (bindingResult.hasErrors()) {
			throw new ValidacaoException();
		}
		
		if (categoriaDao.buscarPorNome(categoriaOcorrencia.getNome()) != null) {
			bindingResult.addError(new FieldError("categoriaOcorrencia", "nome", "Nome já em uso"));
			throw new ValidacaoException();
		}
		
		CategoriaOcorrencia categoriaBuscada = buscar(id);
		categoriaBuscada.setNome(categoriaOcorrencia.getNome());
		categoriaDao.alterar(categoriaBuscada);
		return categoriaBuscada;
		
	}
	
	/**
	 * @return Retorna todas as categorias cadastradas
	 */
	public List<CategoriaOcorrencia> buscarTodos(){
		return categoriaDao.buscarTodos();
	}
	
	public CategoriaOcorrencia buscar(Long id) throws EntidadeNaoEncontradaException {
		//BUsca a categoria do banco
		CategoriaOcorrencia c = categoriaDao.buscar(id);
		
		//Verificando se a categoria buscada não existe
		if(c == null) {
			throw new EntidadeNaoEncontradaException();
		}
		
		return c;
	}
	
 
	/**
	 * Cadastra uma categoria no banco de dados
	 * @param categoria - Categoria que será cadastrada
	 * @param bindingResult - Objeto com erros injetado pelo Spring
	 * @return Categoria que foi cadastrada
	 * @throws ValidacaoException Houver erros de validação nos campos ou o nome estiver duplicado
	 */
	public CategoriaOcorrencia cadastrar(CategoriaOcorrencia categoria, BindingResult bindingResult) throws ValidacaoException {
		
		//Valida os campos
		if(bindingResult.hasErrors()) {
			throw new ValidacaoException();
		}
		
		//Verificando nome duplicado
		if(categoriaDao.buscarPorNome(categoria.getNome()) != null) {
			bindingResult.addError(new FieldError("categoriaOcorrencia", "nome", "Nome já em uso"));
			throw new ValidacaoException();
		}
		
		//Cadastrar no banco de dados
		categoriaDao.persistir(categoria);
		
		//Retornar o objeto cadastrado
		return categoria;
	}

}
