package br.com.docvalidators.filter;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import br.com.docvalidators.util.JwtUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.FilterChain;
import java.io.Serializable;
import java.io.IOException;
import java.util.Objects;

/**
 * Classe responsável pelo filtro de segurança do DOC-Validators.
 * 
 * @author Felipe Nascimento
 * 
 */

public class JwtTokenFilter extends OncePerRequestFilter implements Serializable {
	private static final long serialVersionUID = -1209908403731242374L;

	/**
	 * Método responsável pela interceptação das requisições para validação do Token JWT e obtenção do usuário do DOC-Validators.
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
		
		var header = httpServletRequest.getHeader("Authorization");

        if (Objects.isNull(header) || !header.startsWith("Bearer ")) {
        	
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
            
        }

        var token = header.replace("Bearer ", "");
        var username = JwtUtils.validateTokenAndGetUsername(token);

        if (Objects.nonNull(username)) {
        	
            SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken(username, null, null));
            
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
        
	}
	
}