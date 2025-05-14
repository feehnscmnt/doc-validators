package br.com.docvalidators.component;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import jakarta.servlet.http.HttpServletResponse;
import br.com.docvalidators.model.ResponseModel;
import br.com.docvalidators.util.ValidatorUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import jakarta.servlet.ServletException;
import com.google.gson.Gson;
import java.io.Serializable;
import java.io.IOException;

/**
 * Classe component responsável por criar uma resposta de erro personalizada.
 * 
 * @author Felipe Nascimento
 *
 */

@Component
public class CustomAuthenticationEntryPointComponent implements AuthenticationEntryPoint, Serializable {
	private static final long serialVersionUID = -4377833709051219863L;

	/**
	 * Método responsável pela inicialização de um esquema de autenticação.
	 * 
	 * @param req - {@link HttpServletRequest} - requisição realizada
	 * @param resp - {@link HttpServletResponse} - resposta para que o agente do usuário inicie a autenticação
	 * @param authException - {@link AuthenticationException} - causa da invocação
	 * 
	 */
	@Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
		response.setContentType(ValidatorUtils.CONTENT_TYPE);
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		response.getWriter().write(new Gson().toJson(new ResponseModel("Esta requisição requer elevação para ser executada.", HttpStatus.UNAUTHORIZED, HttpStatus.UNAUTHORIZED.value())));
	}
	
}