package br.senai.sp.info.pweb.jucacontrol.ws.rest.controllers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senai.sp.info.pweb.jucacontrol.models.CategoriaOcorrencia;

@RestController //Este controller retorna DADOS e não uma VIEW
@RequestMapping("/rest/categoriasasddsad")
public class AprenderRestController {
	
	//Simula um banco de dados
	static List<CategoriaOcorrencia> bancoDeDados = new LinkedList<>();
	static Long ultimoId = 3L;
	
	//Adiciona 3 categorias padrão....
	public AprenderRestController() {
		CategoriaOcorrencia c1 = new CategoriaOcorrencia();
		c1.setId(1L);
		c1.setNome("Informática");
		
		CategoriaOcorrencia c2 = new CategoriaOcorrencia();
		c2.setId(2L);
		c2.setNome("Móvel");
		
		CategoriaOcorrencia c3 = new CategoriaOcorrencia();
		c3.setId(3L);
		c3.setNome("Eletrônica");
		
		bancoDeDados.add(c1);
		bancoDeDados.add(c2);
		bancoDeDados.add(c3);
	}
	
	//Buscar todos
	@GetMapping
	public ResponseEntity<Object> buscarTodos(){
		return ResponseEntity.ok(bancoDeDados);
	}
	
	//Cadastro
	//@RequestBody - Avisa pro Spring que o objeto injetado virá do corpo da requisição (JSON)
	@PostMapping
	public ResponseEntity<Object> cadastrar(@RequestBody CategoriaOcorrencia categoria){
		
		//Aplica o id
		ultimoId++;
		categoria.setId(ultimoId);
		
		//Adiciona a categoria na lista
		bancoDeDados.add(categoria);
		
		//MANDAMENTO DO POST: Sempre retornarás o que cadastrastes
		return ResponseEntity.ok(categoria);
	}
	
	private CategoriaOcorrencia buscarPeloId(Long id) {
		
		//Percorre as categorias
		for(CategoriaOcorrencia c : bancoDeDados) {
			//Se da categoria for igual retorna ela
			if(c.getId().equals(id)) {
				return c;
			}
		}
		
		//Caso não encontre retorna nulo
		return null;
	}
	
	//Deletar
	//PAthVariable - Determina que a variável vem do camiho da URL {id}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletar(@PathVariable Long id){
		//Busca a categoria pelo id
		CategoriaOcorrencia categoriaBuscada = buscarPeloId(id);
		
		//Verificando se a categoria existe
		if(categoriaBuscada != null) {
			//Remover a categoria
			bancoDeDados.remove(categoriaBuscada);
			
			//Da a resposta
			return ResponseEntity.noContent().build(); //204 - No Content
		}else {
			return ResponseEntity.notFound().build(); //404 - Not Found
		}
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> buscarUm(@PathVariable Long id){
		//Busca a categoria pelo id
		CategoriaOcorrencia categoriaBuscada = buscarPeloId(id);
		
		//Verificando se a categoria existe
		if(categoriaBuscada != null) {
			return ResponseEntity.ok(categoriaBuscada);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Alterar
	@PutMapping("/{id}")
	public ResponseEntity<Object> alterar(@PathVariable Long id, @RequestBody CategoriaOcorrencia categoria){
		
		//Busca a categoria pelo id
		CategoriaOcorrencia categoriaBuscada = buscarPeloId(id);
		
		//Verificando se a categoria existe
		if(categoriaBuscada != null) {
			
			categoriaBuscada.setNome(categoria.getNome());
			
			//MANDAMENTO PUT: Retornarás o que alterastes
			return ResponseEntity.ok(categoriaBuscada);
			
		}else {
			return ResponseEntity.notFound().build();
		}
		
		
	}

}
