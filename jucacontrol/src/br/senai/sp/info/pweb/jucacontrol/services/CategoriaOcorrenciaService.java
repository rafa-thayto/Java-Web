package br.senai.sp.info.pweb.jucacontrol.services;

import br.senai.sp.info.pweb.jucacontrol.dao.CategoriaOcorrenciaDAO;
import br.senai.sp.info.pweb.jucacontrol.exceptions.EntidadeNaoEncontradaException;
import br.senai.sp.info.pweb.jucacontrol.exceptions.ValidacaoException;
import br.senai.sp.info.pweb.jucacontrol.models.CategoriaOcorrencia;
import br.senai.sp.info.pweb.jucacontrol.utils.MapUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

@Service
public class CategoriaOcorrenciaService {

    @Autowired
    private CategoriaOcorrenciaDAO categoriaDAO;

    /**
     * @return Retorna todas as categorias cadastradas
     */
    public List<CategoriaOcorrencia> buscarTodos() {
        return categoriaDAO.buscarTodos();
    }

    /**
     *
     * @param id - Categoria que foi buscada
     * @return Objeto que foi buscado
     * @throws EntidadeNaoEncontradaException
     */
    public CategoriaOcorrencia buscar(Long id) throws EntidadeNaoEncontradaException {

        // Busca a categoria do banco
        CategoriaOcorrencia categoria = categoriaDAO.buscar(id);

        // Verificando se a categoria buscada não existe
        if (categoria == null) {
            throw new EntidadeNaoEncontradaException();
        }

        return categoria;

    }

    /**
     * Cadastra uma categoria no banco de dados
     * @param categoria - Categoria que sera cadastrada
     * @param brCategoria - Objeto com erros injetado pelo String
     * @return Categoria que foi cadastrada
     * @throws ValidacaoException Se houver erros de validação nos campos ou o nome estiver duplicado
     */
    public CategoriaOcorrencia cadastrar(CategoriaOcorrencia categoria, BindingResult brCategoria) throws ValidacaoException {

        // Valida os campos
        if (brCategoria.hasErrors()) {
            throw new ValidacaoException();
        }

        // Verificando nome duplicado
        if (categoriaDAO.buscarPorNome(categoria.getNome()) != null) {
            brCategoria.addError(new FieldError("categoriaOcorrencia", "nome", "Nome ja em uso"));
            throw new ValidacaoException();
        }

        // Cadastrar no banco de dados
        categoriaDAO.persistir(categoria);

        // Retornar o objeto cadastro
        return categoria;

    }

    /**
     * Deleta uma categoria do banco de dados
     * @param id -Categoria que foi buscada
     * @throws EntidadeNaoEncontradaException 
     */
    public void deletar(Long id) throws EntidadeNaoEncontradaException {

        // Busca e deleta a categoria que vai ser deletada no banco
        categoriaDAO.deletar(this.buscar(id));

    }

    public CategoriaOcorrencia alterar(Long id, CategoriaOcorrencia categoria, BindingResult bindingResult) 
    		throws EntidadeNaoEncontradaException, ValidacaoException {

        CategoriaOcorrencia categoriaBuscada = categoriaDAO.buscarPorNome(categoria.getNome());
        
        if (categoriaBuscada == null) {
        	throw new EntidadeNaoEncontradaException();
        }
        
        if (bindingResult.hasErrors()) {
        	throw new ValidacaoException();
        }
        
        if (categoriaBuscada.getNome() == categoria.getNome()) {
        	bindingResult.addError(new FieldError("categoriaOcorrencia", "nome", "Nome já está em uso"));
        	throw new ValidacaoException();
        } else {
        	categoriaBuscada.setNome(categoria.getNome());
        }

        return categoriaDAO.alterar(categoriaBuscada);
    }

}
