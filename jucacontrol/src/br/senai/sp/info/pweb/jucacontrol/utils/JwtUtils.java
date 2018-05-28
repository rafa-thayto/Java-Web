package br.senai.sp.info.pweb.jucacontrol.utils;

import br.senai.sp.info.pweb.jucacontrol.models.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import java.io.UnsupportedEncodingException;
import java.util.Date;

public class JwtUtils {

    private static String SECRET = "9c7cffb66a1846683838df9b5e259f7e09fb295e429e79dfbb7bf25b17ab02f07e00a7cfc41c41e63b014d8b8a849214f3fa3c5c6f9872d1afced03a21831d7f";

	public static String gerarToken(Usuario usuario)
            throws IllegalArgumentException,
            JWTCreationException,
            UnsupportedEncodingException {

		return JWT.create()
                .withIssuer("SENAI - JucaEncontrol")
                .withIssuedAt(new Date())
                .withSubject("Authentication")
                .withClaim("id", usuario.getId())
                .withClaim("nome", usuario.getNome())
                .withClaim("tipo", usuario.getTipo().toString())
                .withExpiresAt(new Date(new Date().getTime() + 60 * 60 * 1000))
                .sign(Algorithm.HMAC512(SECRET));
	}
	
}
