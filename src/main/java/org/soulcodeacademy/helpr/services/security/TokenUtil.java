package org.soulcodeacademy.helpr.services.security;

// Objetivo desta classe é:
// Validar JWT, Gerar JWT e extrair dados do JWT

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component // instanciar automaticamente o TokenUtil
public class TokenUtil {
    @Value("${senhaJwt}") // injeta o valor da variável no campo abaixo
    private String senhaJwt;

    @Value("${validadeJwt}")
    private Long validadeJwt;

    public String gerarToken(String email, String perfil) {
        // System.currentTimeMillis() => Pega o momento atual em ms
        // new Date(System.currentTimeMillis() + this.validadeJwt) => Indica a data futura que o token vai expirar
        return JWT.create()
                .withSubject(email)
                .withClaim("perfil", perfil)
                .withExpiresAt(new Date(System.currentTimeMillis() + this.validadeJwt))
                .sign(Algorithm.HMAC512(this.senhaJwt));
    }

    public String extrairEmail(String token) {
        return JWT.require(Algorithm.HMAC512(this.senhaJwt))
                .build()
                .verify(token)
                .getSubject(); // dados do email
    }

    public boolean validarToken(String token) {
        // Caso ocorra erro na linha 42, o token passado é inválido:
        // Não foi gerado por nós ou expirou
        try {
            JWT.require(Algorithm.HMAC512(this.senhaJwt))
                    .build()
                    .verify(token);
            return true;
        } catch (JWTVerificationException ex) {
            return false;
        }
    }
}
