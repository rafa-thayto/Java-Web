package br.senai.sp.info.pweb.jucacontrol.utils;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import br.senai.sp.info.pweb.jucacontrol.models.TiposUsuario;
import br.senai.sp.info.pweb.jucacontrol.models.Usuario;

// meio ponto Lucas
public class JwtUtils {
	
	private static String TOKEN_SECRET = "1C5E8F69244CB76D6668AF4660281C13EBE645EF568E413590FC21536FD76B39";
	
	/**
	 * Gera o token do usuário
	 * @param usuario
	 * @return
	 * @throws IllegalArgumentException
	 * @throws JWTCreationException
	 * @throws UnsupportedEncodingException
	 */
	public static String gerarToken(Usuario usuario) 
			throws IllegalArgumentException
			, JWTCreationException
			, UnsupportedEncodingException {
		
		//Calculando a data de expiracao
		Calendar calendarExpiracao = Calendar.getInstance();
		calendarExpiracao.add(Calendar.MINUTE, 60);
		Date dataExpiracao = calendarExpiracao.getTime();
		
		return JWT.create()
			// DADOS GERAIS
			.withIssuer("SENAI - JucaControl")
			.withIssuedAt(new Date())
			.withExpiresAt(dataExpiracao)
			.withSubject("Authentication")
			// PAYLOAD
			.withClaim("id", usuario.getId())
			.withClaim("nome", usuario.getNome())
			.withClaim("tipo", usuario.getTipo().toString())
			// ASSINATURA
			// qual algoritmo de criptografia voc� ir� utilizar
			.sign(Algorithm.HMAC512(TOKEN_SECRET));
					
	}
	
	/**
	 * Valida o token do usuário
	 * @param token
	 * @throws JWTVerificationException
	 * @throws IllegalArgumentException
	 * @throws UnsupportedEncodingException
	 */
	public static void validarToken(String token) throws JWTVerificationException, IllegalArgumentException, UnsupportedEncodingException {
		
		JWT
			.require(Algorithm.HMAC512(TOKEN_SECRET))
			.build()
			.verify(token);
		
	}
	
	/**
	 * Pega os dados do usuário pelo token
	 * @param token
	 * @return
	 */
	public static Usuario extrairUsuarioDoToken(String token) {
		// Criando o objeto usuário que extrairá os dados do token
		Usuario usuario = new Usuario();
		
		// Decodifica o token para ler os dados
		DecodedJWT jwtDecodificado = JWT.decode(token);
		usuario.setId(jwtDecodificado.getClaim("id").asLong());
		usuario.setNome(jwtDecodificado.getClaim("nome").asString());
		usuario.setTipo(TiposUsuario.valueOf(jwtDecodificado.getClaim("tipo").asString()));
		
		return usuario;
	}
	
}
