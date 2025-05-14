package br.com.docvalidators.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import br.com.docvalidators.util.ValidatorUtils;
import org.springframework.http.ResponseEntity;
import br.com.docvalidators.util.JwtUtils;
import java.io.Serializable;
import java.util.Objects;
import java.util.Map;

/**
 * Classe controller responsável pela criação do Token JWT.
 * 
 * @author Felipe Nascimento
 *
 */

@RestController
@RequestMapping
public class TokenController implements Serializable {
	private static final long serialVersionUID = 701657618928396793L;
	
	/**
	 * Método responsável pela geração do Token JWT.
	 * 
	 * @param username - {@link RequestParam} / {@link String} - usuário para autenticação
	 * 
	 * @return Token JWT para uso dos outros endpoints
	 * 
	 */
	@PostMapping("/token")
	public ResponseEntity<Object> generateTokenJwt(@RequestParam String username) {
		
		if (Objects.equals(username, ValidatorUtils.USERNAME)) {
			
			return ResponseEntity.ok(Map.of("access_token", JwtUtils.generateToken(username)));
			
		}
		
		return ResponseEntity.ok(Map.of("unauthorized", String.format("O usuário %s está incorreto ou é inválido.", username)));
		
	}
	
}