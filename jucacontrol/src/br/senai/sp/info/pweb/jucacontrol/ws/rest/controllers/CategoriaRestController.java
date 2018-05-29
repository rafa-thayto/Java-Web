package br.senai.sp.info.pweb.jucacontrol.ws.rest.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senai.sp.info.pweb.jucacontrol.exceptions.EntidadeNaoEncontradaException;
import br.senai.sp.info.pweb.jucacontrol.exceptions.ValidacaoException;
import br.senai.sp.info.pweb.jucacontrol.models.CategoriaOcorrencia;
import br.senai.sp.info.pweb.jucacontrol.services.CategoriaOcorrenciaService;
import br.senai.sp.info.pweb.jucacontrol.utils.MapUtils;

@RestController
@RequestMapping("/rest/categorias")
public class CategoriaRestController {
	
	@Autowired
	private CategoriaOcorrenciaService categoriaService;
	
	// saber qual é a categoria que será deletada
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletar(@PathVariable Long id) {
		try {
			categoriaService.deletarPorId(id);
			return ResponseEntity
						.noContent()
						.build();
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity
					.notFound()
					.header("X-Reason", "Entidade não encontrada")
					.build();
		} catch (Exception e) {
			return ResponseEntity
					.status(500)
					.build();
		}
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> alterar(@PathVariable Long id
			, @Valid @RequestBody CategoriaOcorrencia categoriaOcorrencia
			, BindingResult bindingResult) {
		
		try {
			return ResponseEntity.ok(
					categoriaService
					.alterar(id, categoriaOcorrencia, bindingResult));
		} catch (ValidacaoException e) {
			return ResponseEntity
					.unprocessableEntity()
					.body(MapUtils.mapaDe(bindingResult)); 
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> buscar(@PathVariable Long id){
		try {
			return ResponseEntity.ok(categoriaService.buscar(id));
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(500).build();
		}
	}
	
	@GetMapping
	public ResponseEntity<Object> buscarTodos(){
		
		try {
			
			return ResponseEntity
					.ok(categoriaService.buscarTodos());
			
		} catch (Exception e) {
			
			return ResponseEntity
					.status(500)
					.build();
		}
	}
	
	/**
	 * 
	 * @param categoria
	 * @param bindingResult
	 * @return
	 * <ul>
	 * 	<li>200 - Cadastrado com sucesso</li>
	 * 	<li>422 - Quando houver erros de validação</li>
	 * 	<li>500 - Ocorreu um erro não verificado no servidor</li>
	 * </ul>
	 */
	@PostMapping
	public ResponseEntity<Object> cadastrar(@RequestBody @Valid CategoriaOcorrencia categoria, BindingResult bindingResult){
		
		try {
			
			return ResponseEntity
					.ok(categoriaService.cadastrar(categoria, bindingResult));
			
		} catch (ValidacaoException e) {
			
			return ResponseEntity
					.unprocessableEntity() //422 - UNPROCESSABLE_ENTITY
					.body(MapUtils.mapaDe(bindingResult)); 
			
		} catch (Exception e) {
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR) //500
					.build();  
		}
	}
	

}
