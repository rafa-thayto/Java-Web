package br.senai.sp.info.pweb.jucacontrol.ws.rest.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senai.sp.info.pweb.jucacontrol.exceptions.EntidadeNaoEncontradaException;
import br.senai.sp.info.pweb.jucacontrol.exceptions.ValidacaoException;
import br.senai.sp.info.pweb.jucacontrol.models.Usuario;
import br.senai.sp.info.pweb.jucacontrol.services.UsuarioService;
import br.senai.sp.info.pweb.jucacontrol.utils.JwtUtils;
import br.senai.sp.info.pweb.jucacontrol.utils.MapUtils;

@RestController
@RequestMapping("/rest/auth")
public class AuthRestController {

	// meio ponto Thayto
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/jwt")
	public ResponseEntity<Object> gerarJwt(@Valid @RequestBody Usuario usuario
				, BindingResult bindingResult) {
		
		try {
			// 200
			Usuario usuarioBuscado = usuarioService.buscarPorEmailESenha(usuario, bindingResult);
			Map<String, String> mapaToken = new HashMap<>();
			mapaToken.put("token", JwtUtils.gerarToken(usuarioBuscado));
			return ResponseEntity
						.ok(mapaToken);
		} catch (ValidacaoException e) {
			// 422
			return ResponseEntity
						.unprocessableEntity()
						.body(MapUtils.mapaDe(bindingResult));
		} catch (EntidadeNaoEncontradaException e) {
			// 404
			return ResponseEntity
						.notFound()
						.header("X-Reason", "Entidade não encontrada")
						.build();
		} catch (Exception e) {
			// 500
			return ResponseEntity
						.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.build();
		}
		
	}
	
}