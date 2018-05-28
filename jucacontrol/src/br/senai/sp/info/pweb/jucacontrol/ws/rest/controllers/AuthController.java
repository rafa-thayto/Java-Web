package br.senai.sp.info.pweb.jucacontrol.ws.rest.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import br.senai.sp.info.pweb.jucacontrol.utils.JwtUtils;
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
import br.senai.sp.info.pweb.jucacontrol.utils.MapUtils;

@RestController
@RequestMapping("/rest/auth")
public class AuthController {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/jwt")
	public ResponseEntity<Object> gerarJwt(@RequestBody @Valid Usuario usuario, BindingResult bindingResult) {
		
		try {
			
			Usuario usuarioBuscado = usuarioService.buscarPorEmailESenha(usuario, bindingResult);

			Map<String, String> mapToken = new HashMap<>();
			mapToken.put("token", JwtUtils.gerarToken(usuarioBuscado));
			return ResponseEntity
					.ok(mapToken);
			
		} catch (ValidacaoException e) {
			
			return ResponseEntity
					.unprocessableEntity()
					.body(MapUtils.mapaDe(bindingResult));
			
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
	
}
