package br.com.docvalidators.util;

import java.security.NoSuchAlgorithmException;
import org.apache.logging.log4j.LogManager;
import io.jsonwebtoken.SignatureAlgorithm;
import java.nio.charset.StandardCharsets;
import javax.crypto.spec.SecretKeySpec;
import org.apache.logging.log4j.Logger;
import io.jsonwebtoken.JwtException;
import java.security.MessageDigest;
import io.jsonwebtoken.Jwts;
import java.io.Serializable;
import java.util.Base64;
import java.util.Date;

/**
 * Classe responsável pelo tratamento do token JWT.
 * 
 * @author Felipe Nascimento
 * 
 */

public class JwtUtils implements Serializable {
	private static final Logger LOG = LogManager.getLogger(JwtUtils.class.getName());
	private static final long serialVersionUID = -6757807644473001005L;
	
	/**
     * Método responsável pela geração do token JWT.
     * 
     * @param username - {@link String} - usuário do DOC-Validators
     * 
     * @return token JWT gerado
     * 
     */
    public static String generateToken(String username) {
    	
        return Jwts
        	.builder()
            .setSubject(username)
            .setExpiration(new Date(System.currentTimeMillis() + ValidatorUtils.EXPIRATION_TIME))
            .signWith(SignatureAlgorithm.HS256, generateSecretKey())
            .compact();
        
    }
    
    /**
     * Método responsável por validar o token JWT e obter o usuário do DOC-Validators.
     * 
     * @param token - {@link String} - token JWT
     * 
     * @return nome do usuário do DOC-Validators
     * 
     */
    public static String validateTokenAndGetUsername(String token) {
    	
        try {
        	
        	return Jwts
        		.parser()
                .setSigningKey(generateSecretKey())
                .parseClaimsJws(token)
                .getBody().getSubject();
        	
        } catch (JwtException | IllegalArgumentException e) {
        	
        	LOG.error("Houve erro ao tentar validar e obter o usuário. Exception: {}", e.getMessage());
        	
        }
        
        return null;
        
    }
    
    /**
     * Método responsável por gerar a chave secreta responsável pela assinatura dos tokens.
     *  
     * @return chave secreta
     * 
     */
    public static String generateSecretKey() {
    	
    	try {
    		
    		var key = MessageDigest.getInstance(ValidatorUtils.ALGORITHM_SHA_256).digest(ValidatorUtils.KEY_SECRET.getBytes(StandardCharsets.UTF_8));
        	return Base64.getEncoder().encodeToString(new SecretKeySpec(key, 0, key.length, ValidatorUtils.ALGORITHM_AES).getEncoded());
        	
    	} catch (NoSuchAlgorithmException e) {
    		
    		LOG.error("Houve erro ao tentar gerar a chave secreta. Exception: {}", e.getMessage());
    		
    	}
    	
    	return null;
    	
    }
    
}