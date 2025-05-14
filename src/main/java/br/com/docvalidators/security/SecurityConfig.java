package br.com.docvalidators.security;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import br.com.docvalidators.component.CustomAuthenticationEntryPointComponent;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Bean;
import br.com.docvalidators.filter.JwtTokenFilter;
import org.springframework.http.HttpMethod;
import lombok.AllArgsConstructor;
import java.io.Serializable;

/**
 * Classe responsável pelas configurações de segurança do DOC-Validators.
 * 
 * @author Felipe Nascimento
 *
 */

@Configuration
@AllArgsConstructor
public class SecurityConfig implements Serializable {
	private CustomAuthenticationEntryPointComponent customAuthenticationEntryPointComponent;
	private static final long serialVersionUID = -7242496291938587633L;
	
	/**
	 * Método responsável por criar o filtro de segurança do DOC-Validators.
	 * 
	 * @param httpSecurity - {@link HttpSecurity}
	 * @param jwtTokenFilter - {@link JwtTokenFilter}
	 * 
	 * @return filtro de segurança criado
	 * 
	 * @throws {@link Exception}
	 * 
	 */
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, JwtTokenFilter jwtTokenFilter) throws Exception {

		return httpSecurity
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.authorizeHttpRequests(auth -> auth

			.requestMatchers(HttpMethod.POST, "/token").permitAll()

			.anyRequest().authenticated()).csrf(csrf -> csrf.disable())
			.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
			.exceptionHandling(exception -> exception.authenticationEntryPoint(customAuthenticationEntryPointComponent)).build();
		
	}
	
	/**
	 * Método responsável por criar o bean {@link JwtTokenFilter}.
	 * 
	 * @return bean {@link JwtTokenFilter} criado
	 * 
	 */
	@Bean
	JwtTokenFilter jwtTokenFilter() {
		return new JwtTokenFilter();
	}
	
}