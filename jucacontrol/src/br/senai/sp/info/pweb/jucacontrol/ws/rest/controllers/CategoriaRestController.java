package br.senai.sp.info.pweb.jucacontrol.ws.rest.controllers;

import br.senai.sp.info.pweb.jucacontrol.exceptions.EntidadeNaoEncontradaException;
import br.senai.sp.info.pweb.jucacontrol.exceptions.ValidacaoException;
import br.senai.sp.info.pweb.jucacontrol.models.CategoriaOcorrencia;
import br.senai.sp.info.pweb.jucacontrol.services.CategoriaOcorrenciaService;
import br.senai.sp.info.pweb.jucacontrol.utils.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/rest/categorias")
public class CategoriaRestController {

    @Autowired
    private CategoriaOcorrenciaService categoriaService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscar(@PathVariable Long id) {

        try {

            return ResponseEntity
                    .ok(categoriaService.buscar(id));

        } catch (EntidadeNaoEncontradaException e) {

            return ResponseEntity
                    .notFound()
                    .header("X-REASON", "Entidade n�o encontrada")
                    .build();

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();

        }

    }

    @GetMapping
    public ResponseEntity<Object> buscarTodos() {

        try {
            return ResponseEntity
                    .ok(categoriaService.buscarTodos());

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();

        }

    }

    /**
     *
     * @param categoria
     * @param brCategoria
     * @return
     * <ul>
     *     <li>200 - Cadastro com sucesso</li>
     *     <li>422 - Quando houver erros de validação</li>
     *     <li>500 - Erro no servidor</li>
     * </ul>
     */
    @PostMapping
    public ResponseEntity<Object> cadastrar(@RequestBody @Valid CategoriaOcorrencia categoria, BindingResult brCategoria) {

        try {

            return ResponseEntity
                    .ok(categoriaService.cadastrar(categoria, brCategoria));

        } catch (ValidacaoException e) {

            return ResponseEntity
                    .unprocessableEntity()
                    .body(MapUtils.mapaDe(brCategoria));

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id) {
        try {

        	categoriaService.deletar(id);
        	
            return ResponseEntity
                    .noContent()
                    .build();

        } catch (EntidadeNaoEncontradaException e) {

            return ResponseEntity
                    .notFound()
                    .header("X-REASON", "Entidade não encontrada")
                    .build();

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();

        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> alterar(@PathVariable Long id, @Valid @RequestBody CategoriaOcorrencia categoria, BindingResult bindingResult) {

        try {

            return ResponseEntity
                    .ok(categoriaService.alterar(id, categoria, bindingResult));

        } catch (ValidacaoException e) {
        	
        	return ResponseEntity
        			.unprocessableEntity()
        			.body(MapUtils.mapaDe(bindingResult));
        	
		} catch (EntidadeNaoEncontradaException e) {

            return ResponseEntity
                    .notFound()
                    .header("X-REASON", "Entidade não encontrada")
                    .build();

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();

        }
    }

}
